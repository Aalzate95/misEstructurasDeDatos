/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import tdas.List;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Administrador
 * @param <E>
 */
public class ArrayList<E> implements List<E>,Iterable<E> {
    private int efectivo;
    private E[] array;
    private int capacity = 10;
    
    public ArrayList(){
        array=(E[]) new Object[capacity];
    }
    public boolean addFirst(E element) {
        if(element == null){
            return false;   
        }
        else if (isEmpty()){
            array[efectivo] = element;
            efectivo++;
            return true;
        }
        if(efectivo ==capacity){
            addCapacity();
        }
        for(int i = efectivo -1;i==0;i--){
            array[i+1]=array[i];
        }
        array[0]=element;
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if(element==null){
            return false;
        }
        if(efectivo==capacity){
            addCapacity();
        }
        array[efectivo++]=element;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()){
            return false;
        }
        for( int i = 0; i<efectivo;i++){
            array[i] = array[i+1];
        
        }
        efectivo --;
        return true;
        }

    @Override
    public boolean removeLast() {
        if (isEmpty()){
            return false;
        }
        array[--efectivo]=null;
        return true;
    }

    

    public boolean Contains(E element) {
        for (int i=0;i<efectivo;i++){
            if(array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public boolean insert(int index, E element) {
        if (index>=capacity){
            return false;
        }
        else if(array[index]==null){
            array[index]= element;
            efectivo ++;
            return true;
        }
        else if(efectivo == capacity){
            addCapacity();
        }
        for(int i = efectivo;i>=index;i--){
            array[i+1]=array[i];
        }
        efectivo++;
        array[index]=element;
        return true;
    }
    
    private void addCapacity(){
        E[]tmp = (E[])new Object [capacity*2];
        capacity *= 2;
        for(int i = 0; i<efectivo;i++){
            tmp[i]=array[i];
            
        }
        array=tmp;
    }
    @Override
    public String toString(){
        StringBuilder s= new StringBuilder("[");
        for(int i = 0;i<efectivo;i++){
            s.append(array[i]);
            if (i == efectivo -1){
                s.append("]");
            }
            else{
                s.append(",");
            }
        }
        return s.toString();
    }
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
    public int size() {
        return efectivo;
    }


    public List<E> slicing(int start, int end) {
        List<E> tmp = new ArrayList<>();
        if (start>=0 && end < efectivo){
            for(int i = start;i<end;i++){
                tmp.addLast(array[i]);
            }
        }
        return tmp;
    }

    public List<E> reverse() {
        List<E> tmp = new ArrayList<>();
        for(int i = efectivo; i>=0;i--){
            tmp.addLast(array[i]);
        }
        return tmp;
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
    public boolean contains(E element) {
        if (element == null || isEmpty()){
            return false;
        }
        for (int i = 0;i<efectivo;i++){
            if(array[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public int indexOf(E element) {
        for(int i = 0;i<efectivo;i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return efectivo;
    }

    @Override
    public boolean remove(E element) {
        if(isEmpty()||!contains(element)){
            return false;
        }
        else{
            int index = indexOf(element);
            for(int i = index;i<efectivo-1;i++){
                array[i]=array[i+1];
            }
            efectivo--;
            return true;
        }
        
    }

    @Override
    public E set(int index, E element) {
        if(!(index>efectivo && index<0)&&element!=null){
            if (efectivo == capacity){
                addCapacity();
            }
            else{
                array[index]=element;
            }
        }
        return (E)array;
    }

    @Override
    public E remove(int index) {
        
        if(isEmpty()||index>=capacity){
            return null;
        }
        E n = array[index];
        for(int i = index;i<efectivo-1;i++){
            array[i]=array[i+1];
        }
        efectivo--;
        return n;
    }
    /*
    @Override
    public boolean remove(int index) {
        E[]tmp = (E[])new Object [capacity];
        if (isEmpty()){
            return false;
        }
        if(index>=capacity){
            return false;
        }
        for (int i = 0; i< index;i++){
            tmp[i]=array[i];
        }
        for (int j=index;j<efectivo;j++){
            tmp[j]=array[j+1];
        }
        efectivo--;
        array = tmp;
        return true;
    }*/

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it= new Iterator<E>() {
            private int posicion=0;
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
            return it;
        
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> it = new ListIterator<E>(){
            private int posicion=0;
            @Override
            public boolean hasNext() {
                return posicion< efectivo;
            }

            @Override
            public E next() {
                posicion++;
                return array[posicion-1];
            }

            @Override
            public boolean hasPrevious() {
                return posicion > 0 ;
            }

            @Override
            public E previous() {
                posicion--;
                return array[posicion+1];
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        return null;
    }
}
