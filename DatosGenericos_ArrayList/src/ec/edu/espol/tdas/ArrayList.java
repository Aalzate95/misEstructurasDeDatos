/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;

import ec.edu.espol.tdas.List;

/**
 *
 * @author Administrador
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
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

    @Override
    public E getFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    }

    @Override
    public List<E> slicing(int start, int end) {
        List<E> tmp = new ArrayList<>();
        if (start>=0 && end < efectivo){
            for(int i = start;i<end;i++){
                tmp.addLast(array[i]);
            }
        }
        return tmp;
    }

    @Override
    public List<E> reverse() {
        List<E> tmp = new ArrayList<>();
        for(int i = efectivo; i>=0;i--){
            tmp.addLast(array[i]);
        }
        return tmp;
    }
}
