/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author alexa
 */
public class ArrayList<E> implements List<E> {
    private int efectivo;
    private E[] array;
    private int capacity = 10;
    
    public ArrayList(){
        array = (E[])new Object[capacity];
    }

    @Override
    public boolean addFirst(E element) {
        if(element == null){
            return false;
        }
        else if(isEmpty()){
            array[efectivo]=element;
            efectivo++;
            return true;
        }
        else if(efectivo == capacity){
            addCapacity();
        }
        for(int i=efectivo;i>0;i--){
            array[i]=array[i-1];
        }
        array[0]= element;
        efectivo++;
        return true;
    }
    private void addCapacity(){
        E[] temp = (E[]) new Object[capacity*2];
        capacity *=2;
        for(int i =0;i<efectivo;i++){
            temp[i]=array[i];
        }
        array = temp;
    }

    @Override
    public boolean addLast(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean contains(E element) {
        for(int i = 0;i<efectivo;i++){
            if(array[i].equals(element))
                return true;
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

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean remove(int index) {
        if(index>= efectivo){
            return false;
        }
        for(int i=index;i<efectivo;i++){
            array[i]=array[i+1];
        }
        efectivo--;
        return true;
    }

    @Override
    public List<E> slicing(int start, int end) {
        List<E> temp = new ArrayList<>();
        if(start>=0 && end<efectivo){
            for(int i = end-1;i>=start;i--){
                temp.addFirst(array[i]);
            }
        }
        return temp;
    }

    @Override
    public List<E> reverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for(int i = 0;i<efectivo;i++){
            s.append(array[i]);
            if(i == efectivo-1){
                s.append("]");
            }
            else {
                s.append(",");
            }
        }
        return s.toString();
    }
   
    
}
