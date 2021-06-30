/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;

import java.util.Iterator;

/**
 *
 * @author Ginger Jacome
 */
public class ArrayList<E> implements List<E>,Iterable<E>{
    private int efectivo;
    private E [] array;
    private int capacity=10;

    public ArrayList(){
        this.array= (E[]) new Object [capacity];
        this.efectivo=0;
    }

    private boolean addCapacity(int index){
        E[] ayudante= (E[]) new Object [array.length];
        for (int i=0; i< array.length;i++){
            ayudante[i]= array[i];
        }
        capacity++;
        this.array= (E[]) new Object [ayudante.length+4];
        for(int i=index; i< array.length; i++){
            if(i<ayudante.length){
                this.array[i]= ayudante[i];
            }
        }
        return true;
    }
    @Override
    public boolean addFirst(E elemento) {
        if (elemento==null)
            return false;
        if(capacity==efectivo){
            addCapacity(1);
        }
        E[] ayudante= (E[]) new Object [array.length];
        System.arraycopy(array, 0, ayudante, 0, array.length);
        for(int i=0; i< efectivo; i++){
            array[i+1]= ayudante[i];
            }
        this.array[0]= elemento;
        this.efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E elemento) {
        if(elemento==null)
            return false;
        if(capacity==efectivo){
            addCapacity(0);
        }
        this.array[efectivo++]= elemento;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (efectivo==0)
            return false;
       
        this.efectivo--;
        E[] ayudante= (E[]) new Object [array.length];
        System.arraycopy(array, 0, ayudante, 0, array.length);
        for(int j=0; j< efectivo;j++){
            this.array[j]= ayudante[j+1];
            }
        return true;
    }

    @Override
    public boolean removeLast() {
        if ( efectivo==0)
            return false;
        this.array[--efectivo]= null;
        return true;

    }

    @Override
    public boolean isEmpty() {
        return efectivo==0;
    }

    @Override
    public boolean contains(E elemento) {
        for (int i=0 ; i<efectivo;i++){
            if(array[i].equals(elemento)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int indice) {
        if ( indice > efectivo || indice<0){
            return null;
        }
        return this.array[indice];
    }

    @Override
    public E getFirst() {
        return this.array[0];
    }

    @Override
    public E getLast() {
        return this.array[efectivo-1];
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean remove(int index) {
        if (efectivo==0)
            return false;
        this.efectivo--;
        for(int i=index; i< efectivo; i++){
            this.array[i]= array[i+1];
            }
        return true;
    }

    @Override
    public boolean insert(int index, E elemento) {
        if ( index > efectivo || index<0){
            return false;
        }
        if(index==0)
            return addFirst(elemento);
        if(index== efectivo-1){
            return addLast(elemento);
        }
        E[] ayudante= (E[]) new Object [array.length];
        for (int i=index; i< array.length;i++){
            ayudante[i]= array[i];
        }
        this.array[index]= elemento;
        for(int i=index; i< efectivo; i++){
            this.array[i+1]= ayudante[i];
            }
        efectivo++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i< efectivo; i++){
            sb.append(array[i]);
            if (i<efectivo-1)
                 sb.append(",");
        }
        return "[" + sb +']';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ArrayList))
            return false;
        ArrayList<E> ar= (ArrayList<E>) obj;
        if(ar.efectivo != this.efectivo)
            return false;
        if(ar.efectivo== this.efectivo){
            for(int i=0; i<efectivo;i++){
                if(!ar.contains(array[i]))
                    return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> i= new Iterator<E>() {
            int posicion=0;
            @Override
            public boolean hasNext() {
                return posicion< efectivo;
            }

            @Override
            public E next() {
                posicion++;
                return array[posicion-1];
            }
        };
        return i;
    }
}
