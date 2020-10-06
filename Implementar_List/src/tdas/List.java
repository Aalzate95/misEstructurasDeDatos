/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas;

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
boolean insert(int index, E element);
boolean contains(E element);
E get(int index);
int indexOf(E element);
boolean isEmpty();
E remove(int index); //elimina de la lista el elemento que está en el indice y retorna ese element
boolean remove(E element); // elimina de la lista la primera ocurrencia de element
E set(int index, E elemento); // cambia el contenido del indice
int size();
}
