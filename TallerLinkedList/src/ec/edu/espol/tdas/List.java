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
public interface List<E> {
    boolean addFirst(E elemento);
    boolean addLast(E elemento);
    boolean removeFirst();
    boolean removeLast();
    boolean isEmpty();
    boolean contains(E elemento);
    E get(int indice);
    E getFirst();
    E getLast();
    int size();
    boolean remove( int index);
    boolean insert(int index, E elemento);
    
}

