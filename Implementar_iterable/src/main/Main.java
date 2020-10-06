/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import tdas.ArrayList;
import tdas.DoublyLinkedList;
import tdas.SimplyLinkedList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
        
       /*
        DoublyLinkedList<Integer> b = new DoublyLinkedList<>();
        b.addLast(2);
        b.addFirst(5);
        b.addLast(10);
        b.addLast(20);
        System.out.println(b);
        b.intercambiar();
        System.out.println(b);
        */
       
       LinkedList<Integer> l = new LinkedList<>();
       l.add(5);
       l.add(7);
       l.add(8);
       /*APUNTES:
       ITERATOR 
       -hasNext()
       -next()
       ListIterator
       -hasNext()  boolean
       -next()  E
       -hasPrevious() boolean
       -previous()  E
       -nextIndex() int
       -previousIndex() int
        */
        //RECCORRIDOS
        //RECORRIDO #1
        System.out.println("RECORRIDO #1");
        for(Integer n:l){
            System.out.println(n);
        }
        //RECORRIDO #2
        System.out.println("RECORRIDO #2");
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //RECORRIDO #3
        System.out.println("RECORRIDO #3");
        ListIterator<Integer> li = l.listIterator(l.size());
        while(li.hasPrevious()){
            Integer n2 = li.previous();
            System.out.println(n2);
       } 
        //INDEX
         System.out.println("----------------------------------"
         +"\nIndices:");
        li = l.listIterator();
        System.out.println(li.nextIndex());
        System.out.println(li.previousIndex());
        Integer n3 = li.next();
        System.out.println(li.nextIndex());
        System.out.println(li.previousIndex());
        
        
        //RECORRIDO EN N/2
        ListIterator<Integer> start = l.listIterator();
        ListIterator<Integer> end = l.listIterator(l.size());
        /*while(start.nextIndex()<= end.previousIndex()){
            
        }*/
        
        //RECORRIDO IMPLEMENTANDO ITERATOR
        System.out.println("Recorrido Implementando Iterator en SimplyLinkedList");
        SimplyLinkedList<Integer> simply = new SimplyLinkedList<>();
        simply.addLast(2);
        simply.addLast(4);
        simply.addLast(5);
        for(Integer i:simply){
            System.out.println(i);
        }
        Iterator<Integer> itImplement = simply.iterator();
        while(itImplement.hasNext()){
            System.out.println(itImplement.next());
        }
        
        
        
       /*PRUEBA ARRALIST ITERATOR*/
        System.out.println("PRUEBA ARRALIST CON ITERATOR");
        ArrayList<Integer> array = new ArrayList<>();
        array.addLast(2);
        array.addLast(4);
        array.addLast(10);
        for(Integer j:array){
            System.out.println(j);
        }
        Iterator<Integer> arrayI = array.iterator();
        while(arrayI.hasNext()){
            System.out.println(arrayI.next());
        }
        
        
    }
    
}
