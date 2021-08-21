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
public class Node<E> {
    private E data;
    private Node<E> previous,next;
    public Node(E data){
        this.data=null;
        this.next =this.previous= null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
     public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getPrevious() {
        return previous;
    }
    
}
