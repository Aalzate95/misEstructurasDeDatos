/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import Operaciones.Operaciones;
import java.util.Scanner;

/**
 *
 * @author alexalzate
 * Fecha 10/10/2018
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/** ######################################################################**/        
        // EJERCICIO 1
        int numero;
        int val = 1;
        System.out.println("Ejercicio # 1");
        while(val != 0){
            System.out.println("Ingrese un numero entero positivo: ");
            numero = sc.nextInt();
            if(numero >= 0){
                Operaciones.fibonacciSerie(numero);
                val = 0;
            }
        }
/** ######################################################################**/
        //EJERCICIO 2
        System.out.println("\nEjercicio # 2");
        val = 1;
        while(val != 0){
            System.out.println("Ingrese un numero entero positivo: ");
            numero = sc.nextInt();
            if(numero >= 0){
                Operaciones.numPerfecto(numero);
                val = 0;
            }
        }
/** ######################################################################**/
        //EJERCICIO 3
    }
    
}
