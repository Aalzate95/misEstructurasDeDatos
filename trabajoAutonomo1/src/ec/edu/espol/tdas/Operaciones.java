/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;

/**
 *
 * @author Ginger Jacome
 */
public class Operaciones {

public static int factorial(int n) throws IllegalArgumentException {
    if (n<0)
        throw new IllegalArgumentException("Numero negativo");
    else if (n==0 )
        return 1;
    else
        return n*factorial(n-1);
}
public static boolean busquedaBinaria(int [] data, int target, int low, int high){
    if(low>high)
        return false;
    else{
        int mitad= (low +high)/2;
        if(target== data[mitad])
            return true;
        else if( target<data[mitad])
            return busquedaBinaria(data, target, low, mitad-1);
        else
            return busquedaBinaria(data, mitad+1, low, high);
    }
    }
}
