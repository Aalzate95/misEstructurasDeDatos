/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.tdas.Operaciones;

/**
 *
 * @author Ginger Jacome
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Factorial "+Operaciones.factorial(5));
        int []data= new int[9];
        data[0]=2;
        data[1]=4;
        data[2]=5;
        data[3]=7;
        data[4]=8;
        data[5]=9;
        data[6]=12;
        data[7]=14;
        data[8]=17;
        
        System.out.println("Busqueda Binaria: "+Operaciones.busquedaBinaria(data, 4, 0, 8));
    }
    
}
