/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.modelo;

import espol.edu.ec.presentacion.admin.FormNuevoPaciente;
import espol.edu.ec.modelo.tdas.Medico;
import espol.edu.ec.modelo.tdas.Paciente;
import espol.edu.ec.modelo.tdas.Puesto;
import espol.edu.ec.modelo.tdas.Sintoma;
import espol.edu.ec.presentacion.admin.StageAdmin;
import espol.edu.ec.presentacion.pantalla.Pantalla;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author scmz2607
 */
public class Sistema {
    private static List<Paciente> pacientes;
    private static List<Medico> medicos;
    private static List<Sintoma> sintomas;
    private static List<Puesto> puestos;
    private static PriorityQueue<Paciente> lpriorPacientes;


    private Sistema() {

    }

    public static void inicializar() {
        cargarSintomas();
        cargarPuestos();
        cargarMedicos();
        System.out.println(medicos);
    }

    private static void cargarSintomas() {
        sintomas = new LinkedList<>();
        File f = new File("sintomas.txt");
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] texto = line.split("\\|");
                sintomas.add(new Sintoma(texto[0], Integer.valueOf(texto[1])));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormNuevoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo que devuelve una LinkedList de los Pacientes actuales
    public static void cargarPacientes() {
        pacientes = new LinkedList<>();
        lpriorPacientes = new PriorityQueue<>((Paciente p1, Paciente p2) -> p1.getSintoma().getPrioridad() - p2.getSintoma().getPrioridad());
        File f = new File("pacientes.txt");
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] texto = linea.split(",");
                Paciente p = new Paciente(texto[0], texto[1], texto[2], texto[3], Integer.parseInt(texto[4]), sintomaPorNombre(texto[5]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void cargarPuestos() {
        puestos = new LinkedList<>();
        try {
            File f = new File("puestos.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] texto = line.split(",");
                Puesto p = new Puesto();
                puestos.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe...");
        }
    }

    //Metodo que lee el archivo donde estan los medicos  y devuelve una lista de Medico
    public static void cargarMedicos() {
        medicos = new LinkedList<>();
        try {
            File f = new File("medicos.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] texto = line.split(",");
                Medico m = new Medico(texto[0], texto[1], texto[2], Integer.parseInt(texto[3]));
                int idPuesto = Integer.valueOf(texto[4].trim());
                if (idPuesto!=0) {
                    Puesto pt = puestoPorId(idPuesto);
                    if(pt == null){
                        pt = new Puesto();
                        puestos.add(pt);
                    }
                    m.setPuesto(pt);
                    pt.setMedico(m);
                }
                else{
                    m.setPuesto(null);
                }
                medicos.add(m);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe...");
        }
    }


    //Metodo que permite actualizar la informacion de los medicos
    public static void inicializaMedicosText() {
        
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("medicos.txt"))) {
                for (Medico m : medicos) {
                    if(m.getPuesto()==null)
                        bw.write(m.getCedula() + "," + m.getNombres() + "," + m.getApellidos() + "," + m.getEdad() + ",0");
                    else
                        bw.write(m.getCedula() + "," + m.getNombres() + "," + m.getApellidos() + "," + m.getEdad() + "," + m.getPuesto().getId());
                    bw.newLine();
                }
            }
        catch (IOException ex) {
            Logger.getLogger(StageAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo privado que permite obtener una lista con los sintomas
    public static List<Sintoma> getSintomas() {
        return sintomas;
    }

    public static void addPaciente(Paciente p) {
        pacientes.add(p);
        lpriorPacientes.offer(p);
        if (lpriorPacientes.peek().equals(p))
            asignarConsultorio(p);
    }

    // Metodo que devuelve el Sintoma que se le asigna a cada Paciente
    private static Sintoma sintomaPorNombre(String nomSintoma) {
        return sintomas.stream().filter(s -> s.getTipo().equalsIgnoreCase(nomSintoma)).findAny().orElse(null);
    }

    private static Puesto puestoPorId(int id) {
        return puestos.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public static Medico medPorPuesto(Puesto p) {
        return medicos.stream().filter(m -> m.getPuesto().equals(p)).findAny().orElse(null);
    }

    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    public static List<Medico> getMedicos() {
        return medicos;
    }

    public static List<Puesto> getPuestos() {
        return puestos;
    }

    public static void asignarConsultorio(Paciente p) {
        List<Puesto> desocupados = getDisponiblesAtencion();
        if (!desocupados.isEmpty()){
            desocupados.get(0).setPaciente(p);
            Pantalla.encolarTurnos(desocupados.get(0));
        }
    }
    
    public static void liberarConsultorio(Puesto p){
        if (lpriorPacientes.peek() != null){
            p.setPaciente(lpriorPacientes.poll());
            Pantalla.encolarTurnos(p);
        }
        else
            p.setPaciente(null);
    }

    public static List<Puesto> getDisponiblesAtencion() {
        return puestos.stream().filter(p-> p.getPaciente()== null && p.getMedico()!=null).collect(Collectors.toList());
    }
    
    public static List<Puesto> getConPaciente() {
        return puestos.stream().filter(p-> p.getPaciente()!= null && p.getMedico()!=null).collect(Collectors.toList());
    }
    
    public static PriorityQueue<Paciente> getLpriorPacientes() {
        return lpriorPacientes;
    }

    
    
    
}
