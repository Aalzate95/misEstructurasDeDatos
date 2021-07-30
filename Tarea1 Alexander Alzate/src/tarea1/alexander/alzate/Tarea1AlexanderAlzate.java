/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1.alexander.alzate;

import Funciones.Funciones;



/**
 *
 * @author alexalzate
 */
public class Tarea1AlexanderAlzate {
    public Funciones funcion;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funciones funcion = new Funciones();
        int []data= new int[4];
        data[0]=1;
        data[1]=3;
        data[2]=6;
        data[3]=8;
        System.out.println("Factorial "+Funciones.factorial(10));
        System.out.println("Busqueda Binaria: "+Funciones.busquedaBinaria(data, 2, 0, 4));
    }
    
}
