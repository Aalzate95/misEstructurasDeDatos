/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.tdas;



/**
 *
 * @author Administrador
 */
public abstract class LinkedList<E> implements List<E> {

    private Node<E> first, last;
    private int efectivo;

    public LinkedList() {
        first = last = null;
        this.efectivo = 0;
    }

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

    /*private void setPrevious(Node<E> nodo, Node<E> nuevo){
        for(Node<E> p= this.first; p!= null;p=p.getNext()){
            if(p.getNext()==nodo)
                p=nuevo;
        }
    }*/
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
        if (indice >= efectivo) {
            return null;
        } else {
            int i = 0;
            for (Node<E> p = this.first; i <= indice; p = p.getNext()) {
                if (i == indice) {
                    return (E) p.getData();
                }
                i++;
            }
        }
        return null;
    }

    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (E) first.getData();
    }

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
        if(!(obj instanceof LinkedList) || obj==null){
            System.out.println("callo aqui");
            return false;}
        LinkedList comp= (LinkedList) obj;
        if(this.efectivo==comp.efectivo){
            for (Node<E> p = this.first; p != null; p = p.getNext()) {
                if (!(comp.contains(p)))
                    return true;
            }
        }
        return false;
    }

}