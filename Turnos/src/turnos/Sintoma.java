/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Sintoma {
    private String nombre;
    private int prioridad;

    public Sintoma(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public static List<Sintoma> leerSintomas(String file){
        
        List<Sintoma> lista = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                String nombre = temp[0];
                int prioridad = Integer.parseInt(temp[1]);
                Sintoma element = new Sintoma(nombre,prioridad);
                lista.add(element);
                
                
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
