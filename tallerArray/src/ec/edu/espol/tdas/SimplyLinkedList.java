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
public class SimplyLinkedList<E> implements List<E>, Iterable<E> {

    private Node<E> first, last;
    private int efectivo;

    public SimplyLinkedList() {
        first = last = null;
        this.efectivo = 0;
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
            efectivo++;
            return true;
        }
        this.last.setNext(nuevo);
        this.last = nuevo;
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
            prev.setNext(null);
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
        for (Node<E> p = this.first; p != null; p = p.getNext()) {
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
        return (E) first.getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return (E) last.getData();
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean remove(int index) {
        if(isEmpty()|| index >= efectivo)
            return false;
        if(index==0)
            return removeFirst();
        else if(index==efectivo-1)
            return removeLast();
        Node<E> previo = this.first;
        Node<E> eliminar = this.first;
        Node<E> siguiente = this.first;
        int i = 0;
        for (Node<E> p = this.first; i <= index+1; p = p.getNext()) {
            if (i == index - 1)
                previo = p;
            else if (i == index) 
                eliminar = p;
            else if(i== index+1)
                siguiente= p;
            i++;
        }
        previo.setNext(siguiente);
        eliminar.setData(null);
        efectivo--;
        return true;
    }

    @Override
    public boolean insert(int index, E elemento) {
        if (elemento == null || index >= efectivo) {
            return false;
        }
        if (index == 0)
            return addFirst(elemento);
        Node<E> nuevo = new Node<>(elemento);
        Node<E> previo = this.first;
        Node<E> siguiente = this.first;
        int i = 0;
        for (Node<E> p = this.first; i <= index; p = p.getNext()) {
            if (i == index - 1) {
                previo = p;
            } else if (i == index) {
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
        for (int i = 0; i < efectivo; i++) {
            sb.append(get(i));
            if (i < efectivo - 1) {
                sb.append(",");
            }
        }
        return "[" + sb + ']';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SimplyLinkedList) || obj==null){
            return false;}
        SimplyLinkedList comp= (SimplyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(this.efectivo==comp.efectivo){
            for (Node<E> p = this.first; p != null; p = p.getNext()) {
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
            @Override
            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public E next() {
                E data=p.getData();
                p= p.getNext();
                return data;
            }
        };
        return i;
    }
}
