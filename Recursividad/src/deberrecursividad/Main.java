/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deberrecursividad;

import java.util.Scanner;

/**
 *
 * @author Alexander Alzate
 * @fecha 15/10/2018
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int validar = 1;
        Scanner sc = new Scanner(System.in);
/**###########################################################################**/ 
/**EJERCICIO 1**/
        System.out.println("Ejercicio 1: ");
        while (validar !=0){
            System.out.println("Ingrese un numero entero positivo para multiplicar: ");
            int numero1 = sc.nextInt();
            if (numero1 >= 0){
                System.out.println(Operaciones.multiplicacion(numero1));
                validar = 0;
            }
        }
        validar = 1;
        System.out.println(
                "---------------------------------------");



/**###########################################################################**/ 
/**EJERCICIO 2**/
        System.out.println("Ejercicio 2: ");
        while (validar !=0){
            System.out.println("Ingrese un numero par positivo para transformar a binario: ");
            int numero2 = sc.nextInt();
            if (numero2 >= 0){
                System.out.println(Operaciones.numeroABinario(numero2));
                validar = 0;
            }
        }
        validar = 1;
        System.out.println(
                "---------------------------------------");
/**###########################################################################**/
/**EJERCICIO 3**/
        
        System.out.println("Ejercicio 3: ");
        while (validar !=0){
            System.out.println("Ingrese un numero entero par positivo: ");
            int numero3 = sc.nextInt();
            if (numero3 >= 0 && numero3%2==0){
                System.out.println(Operaciones.sumaEnterosPositivos(numero3));
                validar = 0;
            }
        }
        validar = 1;
        System.out.println(
                "---------------------------------------");
/**###########################################################################**/ 
/**EJERCICIO 4**/
        System.out.println("Ejercicio 4");
        int [] array = new int [4];
        array [0] = 12;
        array[1] = 6;
        array[2] = 4;
        array[3] = 2;
        System.out.println(Operaciones.sumarMedios(array));
        System.out.println(
                "---------------------------------------");
/**###########################################################################**/ 
/**EJERCICIO 5**/
        System.out.println("Ejercicio 5");
        System.out.println(Operaciones.multiplicarArreglo(array));
        System.out.println(
                "---------------------------------------");
    }
    
}
