/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Tdas.Medico;
import Tdas.Paciente;
import Tdas.Sintoma;
import Tdas.Video;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class CargarSistema {
    private static List<Paciente> listPacientes;
    private static List<Medico> listMedicos;
    private static List<Sintoma> listSintomas;
    private static List<Video> listVideos;
    private static PriorityQueue<Paciente> priorPacientes;
    private CargarSistema() {

    }
    
    public static void cargarDatos() {
        leerSintomas("sintomas.txt");
        leerMedicos("medicos.txt");
        leerPacientes("pacientes.txt");
        leerVideos("videos.txt");
    }
    /*public static void addPaciente(Paciente p) {
        listPacientes.add(p);
        priorPacientes.offer(p);
    }*/
    
    public static void leerSintomas(String file){
        
        listSintomas = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String nombre = temp[0];
                int prioridad = Integer.parseInt(temp[1]);
                Sintoma element = new Sintoma(nombre,prioridad);
                listSintomas.add(element);
                
                
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  
    }
    public static void escribirTurno(){
        
    }
    public static void leerVideos(String file){
           
        listVideos = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String url = temp[0];
                Video element = new Video(url);
                listVideos.add(element);
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    public static void leerPacientes(String file){
           
        listPacientes = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String cedula = temp[0];
                String nombre = temp[1];
                String apellido= temp[2];
                String genero = temp[3];
                int edad = Integer.parseInt(temp[4]);
                Sintoma sintoma = new Sintoma();
                for(Sintoma i: listSintomas){
                    if(temp[5].equals(i.getNombre())){
                        sintoma = i;
                    }
                        
                }
                //String cedula, String nombre, String apellido, String genero, int edad,String sintoma
                Paciente element = new Paciente(cedula,nombre,apellido,genero,edad,sintoma);
                listPacientes.add(element);
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    public static void leerMedicos(String file){
           
        listMedicos = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String cedula = temp[0];
                String nombre = temp[1];
                String apellido= temp[2];
                Medico element = new Medico(cedula,nombre,apellido);
                listMedicos.add(element);
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public static List<Paciente> getListPacientes() {
        return listPacientes;
    }

    public static void setListPacientes(List<Paciente> listPacientes) {
        CargarSistema.listPacientes = listPacientes;
    }

    public static List<Medico> getListMedicos() {
        return listMedicos;
    }

    public static void setListMedicos(List<Medico> listMedicos) {
        CargarSistema.listMedicos = listMedicos;
    }

    public static List<Sintoma> getListSintomas() {
        return listSintomas;
    }

    public static void setListSintomas(List<Sintoma> listSintomas) {
        CargarSistema.listSintomas = listSintomas;
    }

    public static List<Video> getListVideos() {
        return listVideos;
    }

    public static void setListVideos(List<Video> listVideos) {
        CargarSistema.listVideos = listVideos;
    }

    
    
    
}
