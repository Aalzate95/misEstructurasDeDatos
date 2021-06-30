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
public class CircularSimplyLinkedList<E> implements List<E>, Iterable<E> {
    
    private Node<E> first, last;
    private int efectivo;
    
    
    public CircularSimplyLinkedList() {
        this.last= this.first=null;
        this.efectivo=0;
    }
    
    
    @Override
    public boolean addFirst(E elemento) {
        if (elemento == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(elemento);
        if (isEmpty()) {
            this.first = this.last = nuevo;
            efectivo++;
            return true;
        }
        nuevo.setNext(this.first);
        this.first = nuevo;
        last.setNext(nuevo);
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E elemento) {
        if (elemento == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(elemento);
        if (isEmpty()) {
            this.first = this.last = nuevo;
            this.last.setNext(first);
            efectivo++;
            return true;
        }
        this.last.setNext(nuevo);
        this.last = nuevo;
        nuevo.setNext(this.first);
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        } else if (this.first == this.last) {
            this.first = this.last = null;
            efectivo--;
            return true;
        } else {
            Node<E> tmp = this.first;
            this.first = this.first.getNext();
            this.last.setNext(this.first);
            tmp.setNext(null);
            tmp.setData(null);
            efectivo--;
            return true;
        }
    }

    private Node<E> getPrevious(Node<E> nodo) {
        for (Node<E> p = this.first; p != null; p = p.getNext()) {
            if (p.getNext() == nodo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        } else if (this.first == this.last) {
            this.first = this.last = null;
            efectivo--;
            return true;
        } else {
            Node<E> prev = getPrevious(this.last);
            prev.setNext(first);
            this.last.setData(null);
            this.last = prev;
            efectivo--;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public boolean contains(E elemento) {
        for (Node<E> p = this.first;p.getNext()!= first; p = p.getNext()) {
            if (p.getData().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int indice) {
        if (indice >= efectivo || isEmpty() || indice < 0) {
            return null;
        } else if (indice == 0) {
            return this.getFirst();
        } else if (indice == efectivo - 1) {
            return this.getLast();
        } else {
            int i = 1;
            for (Node<E> p = this.first.getNext(); i <= indice; p = p.getNext()) {
                if (i == indice) {
                    return (E) p.getData();
                }
                i++;
            }
        }
        return null;
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
    public int size() {
        return efectivo;
    }

    @Override
    public boolean remove(int index) {
        if (isEmpty() || index >= efectivo) {
            return false;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == efectivo - 1) {
            return removeLast();
        }
        int i = 1;
        for (Node<E> p = this.first.getNext(); i <= index; p = p.getNext()) {
            if (i == index){
                Node<E> previo=getPrevious(p);
                previo.setNext(p.getNext());
                p.setData(null);
                efectivo--;
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean insert(int index, E elemento) {
        if (elemento == null || index >= efectivo) {
            return false;
        }
        if (index == 0)
            return addFirst(elemento);
        if(index== efectivo-1)
            return addLast(elemento);
        Node<E> nuevo = new Node<>(elemento);
        Node<E> previo = this.first;
        Node<E> siguiente = this.first;
        int i = 1;
        for (Node<E> p = this.first.getNext(); i <= index; p = p.getNext()) {
            if (i == index) {
                previo=getPrevious(p);
                siguiente = p;
            }
            i++;
        }
        previo.setNext(nuevo);
        nuevo.setNext(siguiente);
        efectivo++;
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Node<E> p = this.first; i<efectivo; p = p.getNext()) {
            sb.append(p.getData());
            if (i < efectivo - 1) {
                sb.append(",");
            }
            i++;
        }
        return "[" + sb + ']';
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CircularSimplyLinkedList) || obj==null){
            return false;}
        CircularSimplyLinkedList comp= (CircularSimplyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(this.efectivo!=comp.efectivo)
            return false;
        if(this.efectivo==comp.efectivo){
            for (Node<E> p = this.first; p.getNext() != this.first ; p = p.getNext()) {
                if (!viajero.getData().equals(p.getData()))
                    return false;
                viajero=viajero.getNext();
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> i= new Iterator<E>() {
            private Node<E> p= first;
            int contador=0;
            @Override
            public boolean hasNext() {
                return contador<efectivo;
            }

            @Override
            public E next() {
                E data=p.getData();
                p= p.getNext();
                contador++;
                return data;
            }
        };
        return i;
    }
}
