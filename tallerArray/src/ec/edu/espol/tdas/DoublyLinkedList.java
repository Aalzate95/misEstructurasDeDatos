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
public class DoublyLinkedList<E> implements List<E>,Iterable<E> {

    Node<E> first, last;
    int efectivo;

    public DoublyLinkedList() {
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
            this.first.getNext().setPrevious(null);
            Node<E> siguiente = this.first.getNext();
            this.first.setNext(null);
            this.first.setData(null);
            this.first = siguiente;
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
            this.last.getPrevious().setNext(null);
            Node<E> previo = this.last.getPrevious();
            this.last.setPrevious(null);
            this.last.setData(null);
            this.last = previo;
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
        if (inicio.getPrevious() != null && fin.getNext() != null && inicio.getPrevious() == fin.getNext() || inicio.getPrevious() == fin) {
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
            return getFirst();
        } else if (indice == efectivo - 1) {
            return getLast();
        } else {
            int i = 1, j = efectivo - 2;
            Node<E> anterior = last.getPrevious();
            for (Node<E> p = first.getNext(); p != null; p = p.getNext()) {
                if (i == indice) {
                    return p.getData();
                } else if (j == indice) {
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
        } else {
            int i = 1, j = efectivo - 1;
            Node<E> back = this.last.getPrevious();
            for (Node<E> p = this.first.getNext(); p != null; p = p.getNext()) {
                if (i == index) {
                    back = p.getNext(); //reutilizando nodo, en realidad es un "siguiente"
                    p.getPrevious().setNext(back);
                    p.setData(null);
                    back.setPrevious(p.getPrevious());
                    efectivo--;
                    return true;
                } else if (j == index) {
                    p = back.getNext(); //reutilizando nodo, en realidad es un "siguiente"
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
        if (elemento == null || index >= efectivo) {
            return false;
        } else if (index == 0) {
            return addFirst(elemento);
        } else if (index == efectivo - 1) {
            return addLast(elemento);
        } else {
            int i = 1, j = efectivo - 1;
            Node<E> nuevo= new Node<>(elemento);
            Node<E> back = this.last.getPrevious();
            for (Node<E> p = this.first.getNext(); p != null; p = p.getNext()) {
                if (i == index) {
                    p.getPrevious().setNext(nuevo);
                    nuevo.setNext(p);
                    nuevo.setPrevious(p.getPrevious());
                    p.setPrevious(nuevo);
                    efectivo++;
                    return true;
                }
                else if (j== index){
                    back.getNext().setPrevious(nuevo);
                    nuevo.setNext(back.getNext());
                    nuevo.setPrevious(back);
                    back.setNext(nuevo);
                    efectivo--;
                    return true;
                }
                back.getPrevious(); i++; j--;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Node<E> p = this.first; p != null; p = p.getNext()) {
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
        if(!(obj instanceof DoublyLinkedList) || obj==null){
            return false;}
        DoublyLinkedList comp= (DoublyLinkedList) obj;
        Node<E> viajero= comp.first;
        if(this.efectivo!= comp.efectivo)
            return false;
        if(this.efectivo==comp.efectivo){
            for (Node<E> p = this.first; p != null; p = p.getNext()) {
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
            private Node<E> f= last;
            @Override 
            public boolean hasNext() {
                return p!=null || f!=null;
            }

            @Override
            public E next() {
                E data=p.getData();
                p= p.getNext();
                f= f.getPrevious();
                return data;
            }
        };
        return i;
    }
    
}
