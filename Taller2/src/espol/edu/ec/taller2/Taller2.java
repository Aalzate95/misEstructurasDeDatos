/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.taller2;
import java.util.Scanner;
/**
 *
 * @author Administrador
 */
public class Taller2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int [] array = new int [3];
        array [0] = 8;
        array[1] = 4;
        array[2] = 5;
        Scanner entrada = new Scanner(System.in);
        int numero ;
        int numero2;
        System.out.println("Ejercicio 1");
        System.out.println("Ingrese un numero");
        numero = entrada.nextInt();
        System.out.println(Operaciones.multiplicacion(numero));
        System.out.println("Ejercicio 2");
        System.out.println(Operaciones.binarios(8));
        System.out.println("Ejercicio 3");
        System.out.println("Ingrese un numero");
        numero2 = entrada.nextInt();
        System.out.println(Operaciones.suma(numero2));
        System.out.println("Ejercicio 5");
        System.out.println(Operaciones.multVector(array));
        System.out.println("Ejercicio 4");
        System.out.println(Operaciones.sumMedios(array));
    }
    
}
