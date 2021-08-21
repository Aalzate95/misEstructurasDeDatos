/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;

/**
 *
 * @author alexa
 */
public class SimplyLinkedList<E> implements List<E> {
    private Node<E> first,last;
    private int efectivo;
    //Constructor
    public SimplyLinkedList(){
        this.first=last=null;
        efectivo = 0;
    }
    
    @Override
    public boolean addFirst(E element) {
        Node<E> nodo = new Node<E>(element);
        if(element == null){
            return false;
        }
        else if (isEmpty()){
            first = last =nodo;
        }
        else{
            nodo.setNext(first);
            first = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> nodo = new Node<E>(element);
        if (element == null){
            return false;
        }
        else if (isEmpty()){
            last =first= nodo;
        }
        else{
            last.setNext(nodo);
            last = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()){
            return false;
        }
        else if(first == last){
            first = last =null;
        }
        else{
            Node<E> temp = first;
            temp.setNext(null);
            temp.setData(null);
            first = first.getNext();
        }
        efectivo--;
        return true;
    }
    public Node<E> getPrevious(Node<E> nodo){
        for (Node<E> i = first; i != null; i = i.getNext()) {
            if (i.getNext() == nodo) {
                return i;
            }
        }
        return null;
    }
    @Override
    public boolean removeLast() {
        if(isEmpty()){
            return false;
        }
        else if(first == last){
            first = last = null;
        }
        else{
            Node<E> temp = getPrevious(last);
            last.setData(null);
            last = temp;
            last.setNext(null);
        }
        efectivo--;
        return true;
    }
    @Override
    public E getFirst() {
        return first.getData();
    }

    @Override
    public E getLast() {
        return last.getData();
    }
    

    @Override
    public boolean insert(int index, E element) {
        if (element == null || index >= efectivo) {
            return false;
        }
        else if (index == 0){
            return addFirst(element);
        }
        else{
            Node<E> nuevo = new Node<>(element);
            Node<E> previo = first;
            Node<E> siguiente = first;
            int i = 0;
            for (Node<E> p = first; i <= index; p = p.getNext()) {
                if (i == index - 1) {
                    previo = p;
                } else if (i == index) {
                    siguiente = p;
                }
                i++;
            }
            previo.setNext(nuevo);
            nuevo.setNext(siguiente);
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean contains(E element) {
        for (Node<E> p = first; p != null; p = p.getNext()) {
            if (p.getData().equals(element)) {
               return true;
           }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= efectivo || isEmpty() || index < 0) {
            return null;
        } 
        else if (index == 0) {
            return this.getFirst();
        } 
        else if (index == efectivo - 1) {
            return this.getLast();
        }
        else{
            int i = 0;
            for (Node<E> p = first; i <= index; p = p.getNext()) {
                if (i == index) {
                    return (E) p.getData();
                }
                i++;
            }
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        int count = 0;
        if (contains(element)){
            
            for (Node<E> p = first; p != null; p = p.getNext()) {
                if (p.getData().equals(element)) {
               
                return count;
                }
            count++;
            }
        }
        return count;
    }
    

    @Override
    public boolean isEmpty() {
        return first==null && last ==null;
    }

    
    public boolean equals(Object obj) {
        if(!(obj instanceof SimplyLinkedList) || obj==null){
            return false;
        }
        SimplyLinkedList comp= (SimplyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(efectivo==comp.efectivo){
            for (Node<E> p = first; p != null; p = p.getNext()) {
                if (!viajero.getData().equals(p.getData()))
                    return false;
                viajero=viajero.getNext();
            }
        }
        return true;
    }
    @Override
    public int size() {
        return efectivo;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < efectivo; i++) {
            sb.append(get(i));
            if (i < efectivo - 1) {
                sb.append(",");
            }
        }
        return "[" + sb + ']';
    }
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
