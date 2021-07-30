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
public interface List<E> {
    boolean addFirst(E element);
    boolean addLast(E element);
    boolean removeFirst();
    boolean removeLast();
    E getFirst();
    E getLast();
    boolean contains( E element);
    boolean isEmpty();
    boolean insert(int index, E element);
    int size();
    boolean remove(int index);
    List<E> slicing (int start,int end);
    List<E> reverse();
    
}
