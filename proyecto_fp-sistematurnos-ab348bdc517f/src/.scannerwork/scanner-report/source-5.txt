/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.modelo.tdas;

/**
 *
 * @author scmz2607 para clases
 * @param <E>
 */
public interface List<E>{
    boolean addFirst(E el);
    boolean addLast(E el);
    boolean removeFirst();
    boolean removeLast();
    E getFirst();
    E getLast();
    boolean insert(int index, E el);
    boolean contains(E el);
    E get(int index);
    int indexOf(E element);
    E remove(int index); //elimina de la lista el elemento que está en el indice 
    //y retorna ese element
    boolean isEmpty();
    int size();
    boolean remove(E element); // elimina de la lista la primera ocurrencia de element
    E set(int index, E element); // cambia el contenido del indice
    
}

