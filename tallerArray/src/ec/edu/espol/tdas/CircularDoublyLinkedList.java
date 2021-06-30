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
public class CircularDoublyLinkedList<E> implements List<E>,Iterable<E> {
    Node<E> first, last;
    int efectivo;

    public CircularDoublyLinkedList() {
        this.first = this.first = null;
        this.efectivo = 0;
    }

    @Override
    public boolean addFirst(E elemento) {
        if (elemento == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(elemento);
        if (this.isEmpty()) {
            this.first = this.last = nuevo;
        } else {
            nuevo.setNext(this.first);
            this.first.setPrevious(nuevo);
            this.first = nuevo;
            this.last.setNext(nuevo);
            nuevo.setPrevious(this.last);
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E elemento) {
        if (elemento == null) {
            return false;
        }
        Node<E> nuevo = new Node<>(elemento);
        if (this.isEmpty()) {
            this.first = this.last = nuevo;
        } else {
            nuevo.setPrevious(this.last);
            this.last.setNext(nuevo);
            this.last = nuevo;
            nuevo.setNext(this.first);
            this.first.setPrevious(nuevo);
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty()) {
            return false;
        } else if (this.first == this.last) {
            this.first.setData(null);
            this.first = this.last = null;
            efectivo--;
            return true;
        } else {
            this.first.getNext().setPrevious(this.last);
            Node<E> siguiente = this.first.getNext();
            this.first.setNext(null);
            this.first.setData(null);
            this.first = siguiente;
            this.last.setNext(this.first);
            efectivo--;
            return true;
        }
    }

    @Override
    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        } else if (this.first == this.last) {
            this.first.setData(null);
            this.first = this.last = null;
            efectivo--;
            return true;
        } else {
            this.last.getPrevious().setNext(this.last);
            Node<E> previo = this.last.getPrevious();
            this.last.setPrevious(null);
            this.last.setData(null);
            this.last = previo;
            this.first.setPrevious(this.last);
            efectivo--;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null && this.last == null;
    }

    @Override
    public boolean contains(E elemento) {
        if (elemento == null || isEmpty()) {
            return false;
        } else if (first == last && first.getData().equals(elemento)) {
            return true;
        }
        return contains(elemento, first, last);
    }

    private boolean contains(E elemento, Node<E> inicio, Node<E> fin) {
        if (inicio.getPrevious() != last && fin.getNext() != first && inicio.getPrevious() == fin.getNext()) {
            return false;
        } else if (inicio.getData().equals(elemento) || fin.getData().equals(elemento)) {
            return true;
        }
        return contains(elemento, inicio.getNext(), fin.getPrevious());
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
            int i = 1, j = efectivo - 2;
            Node<E> back = this.last.getPrevious();
            for (Node<E> p = this.first.getNext(); i<=indice+1; p = p.getNext()) {
                if (i == indice) {
                    return p.getData();
                } else if (j == indice) {
                    return back.getData();
                }
                i++;
                j--;
                back = back.getPrevious();
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
        if (isEmpty() || index >= efectivo || index<0) {
            return false;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == efectivo - 1) {
            return removeLast();
        } else {
            int i = 1, j = efectivo - 1;
            Node<E> back = this.last.getPrevious();
            for (Node<E> p = this.first.getNext(); i<=index; p = p.getNext()) {
                if (i == index) {
                    back = p.getNext(); 
                    p.getPrevious().setNext(back);
                    p.setData(null);
                    back.setPrevious(p.getPrevious());
                    efectivo--;
                    return true;
                } else if (j == index) {
                    p = back.getNext();
                    back.getPrevious().setNext(p);
                    back.setData(null);
                    p.setPrevious(back.getPrevious());
                    efectivo--;
                    return true;
                }
                back.getPrevious();
                i++;
                j--;
            }
        }
        return false;
    }

    @Override
    public boolean insert(int index, E elemento) {
        Node<E> nuevo= new Node<>(elemento);
        if (elemento == null || index >= efectivo) {
            return false;
        } else if (index == 0) {
            return addFirst(elemento);
        } else if (index == efectivo - 1) {
            last.getPrevious().setNext(nuevo);
            nuevo.setNext(last);
            nuevo.setPrevious(last.getPrevious());
            last.setPrevious(nuevo); efectivo++; return true;
        } else {
            int i = 1;
            for (Node<E> p = this.first.getNext(); i<=index; p = p.getNext()) {
                if (i == index) {
                    p.getPrevious().setNext(nuevo);
                    nuevo.setNext(p);
                    nuevo.setPrevious(p.getPrevious());
                    p.setPrevious(nuevo);
                    efectivo++;
                    return true;
                
                }
                i++;
            }
        }
        return false;
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
        if(!(obj instanceof CircularDoublyLinkedList) || obj==null){
            return false;}
        CircularDoublyLinkedList comp= (CircularDoublyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(this.efectivo!= comp.efectivo)
            return false;
        if(this.efectivo==comp.efectivo){
            for (Node<E> p = this.first; p.getNext()!= first; p = p.getNext()) {
                if (!p.getData().equals(viajero.getData()))
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
