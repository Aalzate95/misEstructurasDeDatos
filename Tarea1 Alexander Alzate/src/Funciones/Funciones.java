/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

/**
 *
 * @author alexalzate
 */
public class Funciones {
public static int factorial(int a) throws IllegalArgumentException {
    if (a<0)
        throw new IllegalArgumentException("Negativo");
    else if (a==0 )
        return 1;
    else
        return a*factorial(a-1);
}
public static boolean busquedaBinaria(int [] data, int target, int bajo, int alto){
    if(bajo>alto)
        return false;
    else{
        int medio= (bajo +alto)/2;
        if(target== data[medio])
            return true;
        else if( target<data[medio])
            return busquedaBinaria(data, target, bajo, medio-1);
        else
            return busquedaBinaria(data, medio+1, bajo, alto);
        }
    }
}


