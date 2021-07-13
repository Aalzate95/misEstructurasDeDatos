/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber_conjuntos;

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
        SLSet<Integer> list1 = new SLSet<>(Integer::compareTo);
        SLSet<Integer> list2 = new SLSet<>(Integer::compareTo);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(15);
        list1.remove(3);
        System.out.println(list1);
        list2.add(6);
        list2.add(7);
        list2.add(3);
        list2.add(15);
        
        list2.remove(6);
        System.out.println(list2);
        System.out.println("La diferencia es: " + list1.Diference(list2));
        System.out.println("la union es: "+list2.Union(list1));
        System.out.println("la intercepcion es: "+list2.Interception(list1));
    }
    
    
}
