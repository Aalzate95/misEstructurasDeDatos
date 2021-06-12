/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deberrecursividad;

/**
 *
 * @author alexa
 */
public class Operaciones {
    public static int multiplicacion(int numero){
        if (numero == 1){
            return 1;
        }
        else{
            return numero * multiplicacion(numero-1);
        }
    }
    public static int numeroABinario(int numero){
        if(numero  == 0){
            return 0;
        }
        else{
            return numero%2 + 10*numeroABinario(numero/2);
        }
    }
    
    public static int sumaEnterosPositivos(int numero){
        
        if (numero == 2)
            return 2;
        else {
            return sumaEnterosPositivos(numero - 2)+numero;
        }
    }
    private static Object[] cambiar;
    public static int sumarMedios (int [] array ){
        cambiar = new Object[array.length];
        int maximo = array.length;
        for (int i = 0; i<array.length; i++) {
            cambiar[maximo - 1] = array[i];
            maximo--;
        }
        return 0;
     }
    public static int multiplicarArreglo(int []array){
        return  multiplicarArreglo(array, array.length-1);
    }
    private static int multiplicarArreglo( int []array, int posicion ){
        if ( posicion== 0)
            return array[0];
        return array[posicion]* multiplicarArreglo(array, posicion-1);
}
    
}
