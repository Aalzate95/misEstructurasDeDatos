/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import tdas.ArrayList;
import tdas.SimplyLinkedList;

/**
 *
 * @author alexa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //PRUEBA ARRAYLIST
        System.out.println("PRUEBA METODOS ARRAYLIST");
        ArrayList<Integer> a = new ArrayList<>();
        a.addFirst(2);
        a.addLast(8);
        a.addLast(10);
        a.addLast(12);
        a.addLast(24);
        System.out.println("Se imprime el arreglo base: \n"+a.toString());
        a.removeFirst();
        System.out.println("Se remueve el primer elemento: \n"+a.toString());
        a.removeLast();
        System.out.println("Se remueve el ultimo elemento: \n"+a.toString());
        
        System.out.println("Se comprueba si existe el elemento 4: \n"+a.contains(4));
        System.out.println("Se comprueba si existe el elemento 8: \n"+a.contains(8));
        a.insert(2,22);
        System.out.println("Se inserta el elemento 22 en la posicion 2: \n"+a.toString());
        System.out.println("Se seleccionan los 3 primeros elementos: \n"+a.slicing(0, 3));
        
    }
    
}
