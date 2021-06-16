/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolas;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Proceso {
    
    private int tiempoLlegada;
    private String nombre;
    private int tiempoProcesamiento;
    private int prioridad;

    public Proceso(int tiempoLlegada, String nombre, int tiempoProcesamiento, int prioridad) {
        this.tiempoLlegada = tiempoLlegada;
        this.nombre = nombre;
        this.tiempoProcesamiento = tiempoProcesamiento;
        this.prioridad = prioridad;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }

    public void setTiempoProcesamiento(int tiempoProcesamiento) {
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
    public static List<Proceso> readFromFile(String file){
        List<Proceso> lista = new LinkedList<>();
        try {
            
            Scanner sc = new Scanner(new File(file));


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] temp = line.split("\\|");
                int tl =  Integer.parseInt(temp[0]);
                int t2 = Integer.parseInt(temp[2]);
                int t3 = Integer.parseInt(temp[2]);
                Proceso element = new Proceso(tl,temp[1],t2,t3);
                lista.add(element);
                
                
            }
            
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
        
    
    }
    public String toString(){
        return "Proceso("+"tiempoLLegada"+tiempoLlegada+",nombre"+nombre+"tiempoProcesamiento"+tiempoProcesamiento;
    }
}
