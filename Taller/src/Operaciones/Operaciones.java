/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

/**
 *
 * @author alexa
 */
public class Operaciones {
    
/**######################################################################**/
//EJERCICIO 1    
    public static int fibonacci (int numero){
        if (numero == 0){
            return 0;
        }
        else if (numero == 1){
            return 1;
        }
        return fibonacci(numero-1)+fibonacci(numero-2);
        
    }
    
    public static void fibonacciSerie(int numero){
        for (int i =0; i<numero;i++){
            if(fibonacci(i)<=numero){
                System.out.print(fibonacci(i)+" ");
            }
            
        }
    }
/**######################################################################**/
//EJERCICIO 2
    public static void numPerfecto(int numero){
        int suma =0;
        for (int i= 1;i<numero;i++){
            if (numero % i ==0){
                suma = suma +i;
            }
        }
        if (suma == numero){
            System.out.println("Es un numero Perfecto");
        }
        else{
            System.out.println("No es un numero Perfecto");
        }
    }
/** ######################################################################**/
//EJERCICIO 3
    public static void cantidadAsientos(int numero){
        
    }
}
