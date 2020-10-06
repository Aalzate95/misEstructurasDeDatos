/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

import java.util.Iterator;

/**
 *
 * @author alexa
 */
public class DoublyLinkedList<E> implements List<E>, Iterable {
    private Node<E> first, last;
    private int efectivo;
    public DoublyLinkedList() {
        first = last = null;
        this.efectivo = 0;
    }
    @Override
    public boolean addFirst(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nodo = new Node<>(element);
        if (isEmpty()) {
            first = last = nodo;
        } else {
            nodo.setNext(first);
            first.setPrevious(nodo);
            first = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if (element == null) {
            return false;
        }
        Node<E> nodo = new Node<>(element);
        if (isEmpty()) {
            first = last = nodo;
        } else {
            nodo.setPrevious(last);
            last.setNext(nodo);
            last = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } 
        else if (first == last) {
            first.setData(null);
            first = last = null;
            
        } 
        else {
            first.getNext().setPrevious(null);
            Node<E> siguiente = first.getNext();
            first.setData(null);
            first.setNext(null);
            first = siguiente;
            
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        } 
        else if (first == last) {
            first.setData(null);
            first = last = null;
            
        } 
        else {
            last.getPrevious().setNext(null);
            Node<E> previo = last.getPrevious();
            last.setPrevious(null);
            last.setData(null);
            last = previo;
        }
        efectivo--;
        return true;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.getData();
    }

    @Override
    public boolean insert(int index, E element) {
        if (element == null || index >= efectivo) {
            return false;
        } else if (index == 0) {
            return addFirst(element);
        } else if (index == efectivo - 1) {
            return addLast(element);
        } else {
            int i = 1, j = efectivo - 1;
            Node<E> nuevo= new Node<>(element);
            Node<E> anterior = last.getPrevious();
            for (Node<E> p = first.getNext(); p != null; p = p.getNext()) {
                if (i == index) {
                    p.getPrevious().setNext(nuevo);
                    nuevo.setNext(p);
                    nuevo.setPrevious(p.getPrevious());
                    p.setPrevious(nuevo);
                    efectivo++;
                    return true;
                }
                else if (j== index){
                    anterior.getNext().setPrevious(nuevo);
                    nuevo.setNext(anterior.getNext());
                    nuevo.setPrevious(anterior);
                    anterior.setNext(nuevo);
                    efectivo--;
                    return true;
                }
                anterior.getPrevious(); i++; j--;
            }
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        } else if (first == last && first.getData().equals(element)) {
            return true;
        }
        return contains(element, first, last);
    }
    private boolean contains(E element, Node<E> inicio, Node<E> end) {
        if (inicio.getPrevious() != null && end.getNext() != null && inicio.getPrevious() == end.getNext() || inicio.getPrevious() == end) {
            return false;
        } else if (inicio.getData().equals(element) || end.getData().equals(element)) {
            return true;
        }
        return contains(element, inicio.getNext(), end.getPrevious());
    }

    @Override
    public E get(int index) {
        if (index >= efectivo || isEmpty() || index < 0) {
            return null;
        } else if (index == 0) {
            return getFirst();
        } else if (index== efectivo - 1) {
            return getLast();
        } else {
            int i = 1, j = efectivo - 2;
            Node<E> anterior = last.getPrevious();
            for (Node<E> p = first.getNext(); p != null; p = p.getNext()) {
                if (i == index) {
                    return p.getData();
                } else if (j == index) {
                    return anterior.getData();
                }
                i++;
                j--;
                anterior = anterior.getPrevious();
            }
        }
        return null;
    }

    
    @Override
    public int size() {
        return efectivo;
    }
    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Node<E> p = first; p != null; p = p.getNext()) {
            sb.append(p.getData());
            if (i < efectivo - 1) {
                sb.append(",");
            }
            i++;
        }
        return "[" + sb + ']';
    }
    public boolean equals(Object obj) {
        if(!(obj instanceof DoublyLinkedList) || obj==null){
            return false;
        }
        DoublyLinkedList comp = (DoublyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(efectivo!= comp.efectivo)
            return false;
        if(efectivo==comp.efectivo){
            for (Node<E> p = first; p != null; p = p.getNext()) {
                if (!p.getData().equals(viajero.getData()))
                    return false;
                viajero=viajero.getNext();
            }
        }
        return true;
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
    @Override
    public int indexOf(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
