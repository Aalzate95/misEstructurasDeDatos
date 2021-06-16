/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallercolas;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //cola simple
        List<Proceso> proceso = Proceso.readFromFile("procesos.txt");
        proceso.sort((Proceso p1,Proceso p2)->p1.getTiempoLlegada()- p2.getTiempoLlegada());
        Queue<Proceso> cola = new LinkedList<>();
        while(!cola.isEmpty()){
            Proceso p = cola.poll();
            System.out.println("Nombre: "+p.getNombre()+" tiempo de ejecución : "+p.getTiempoProcesamiento()+"\nNuevo tiempo de ejecución: "+(p.getTiempoProcesamiento()-1));
            p.setTiempoProcesamiento(p.getTiempoProcesamiento()-1);
            cola.offer(p);
        }
        //cola prioridad
        proceso = Proceso.readFromFile("procesos.txt");
        PriorityQueue<Proceso> colaPrioridad = new PriorityQueue<>((Proceso p1,Proceso p2)->p1.getPrioridad()-p2.getPrioridad());
    }
    
}
