/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.main;

import ec.edu.espol.tdas.ArrayList;
import ec.edu.espol.tdas.CircularDoublyLinkedList;
import ec.edu.espol.tdas.CircularSimplyLinkedList;
import ec.edu.espol.tdas.DoublyLinkedList;
import ec.edu.espol.tdas.SimplyLinkedList;
import java.util.Iterator;

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
        DoublyLinkedList<Integer> lista2 = new DoublyLinkedList<>();lista2.addFirst(300); //Lista para comparar
        SimplyLinkedList lista= new SimplyLinkedList<>();
        //DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();
        //CircularDoublyLinkedList lista= new CircularDoublyLinkedList<>();
        //CircularSimplyLinkedList<Integer> lista= new CircularSimplyLinkedList<>();
        //ArrayList lista= new ArrayList<>();
        System.out.println("Lista vacia: " + lista.isEmpty() + "\nNumero de elementos: " + lista.size());
        System.out.println("Añadiendo un elemento al principio: " + lista.addFirst(9));
        System.out.println(lista);
        System.out.println("Añadiendo 3 elementos al principio: " + lista.addFirst(3)+ lista.addFirst(24)+ lista.addFirst(54));
        System.out.println(lista);
        System.out.println("Añadiendo un elemento al final: " + lista.addLast(10));
        System.out.println(lista);
        System.out.println("Lista contiene tal elemento: " +lista.contains(54));
        System.out.println("Insertando elemento en cierto indice: " + lista.insert(3, 70));
        System.out.println(lista);
        System.out.println("Insertando elemento en cierto indice: " + lista.insert(1, 300));
        System.out.println(lista);
        System.out.println("Insertando elemento en cierto indice: " + lista.insert(2, 60));
        System.out.println(lista);
        System.out.println("Obtener primer elemento: " + lista.getFirst());
        System.out.println("Obtener ultimo elemento: " + lista.getLast());
        System.out.println("Obtener elemento en cierto indice: " + lista.get(2));
        System.out.println("Numero de elementos: "+lista.size());
        System.out.println("Remove first: "+lista.removeFirst());
        System.out.println(lista);
        System.out.println("Remove last: "+ lista.removeLast());
        System.out.println(lista);
        System.out.println("Remove en cierto indice: "+lista.remove(1));
        System.out.println(lista);
        System.out.println("La lista esta vacia: "+lista.isEmpty());
        System.out.println("Numero de elementos: "+lista.size());
        System.out.println("Las listas son iguales: "+lista.equals(lista));
        Iterator<Integer> it= lista.iterator();
        while(it.hasNext()){
            Integer num= it.next();
            System.out.println(num);
        }
    }

}
