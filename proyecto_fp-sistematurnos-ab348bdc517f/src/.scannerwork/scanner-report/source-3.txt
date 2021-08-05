/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.modelo.tdas;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author scmz2607
 * @param <E>
 */
public class DoublyCircularList<E> implements List<E>, Iterable<E> {

    private Node<E> last;
    private int efectivo;

    public DoublyCircularList() {
        efectivo = 0;
        last = null;
    }

    @Override
    public boolean addFirst(E el) {
        if (el == null) {
            return false;
        }
        Node<E> n = new Node<>(el);
        if (isEmpty()) {
            last = n;
            last.setNext(n);
            last.setPrevious(n);
        } else {
            n.setNext(last.getNext());
            n.setPrevious(last);
            last.getNext().setPrevious(n);
            last.setNext(n);
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E el) {
        if (el == null) {
            return false;
        }
        Node<E> n = new Node<>(el);
        if (isEmpty()) {
            last = n;
            last.setNext(n);
            last.setPrevious(n);
        } else {
            n.setNext(last.getNext());
            n.setPrevious(last);
            last.getNext().setPrevious(n);
            last.setNext(n);
            last = n;
        }

        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }
        if (last.getNext() == last) {
            last.setPrevious(null);
            last.setNext(null);
            last = null;
        } else {
            Node<E> tmp = last.getNext();
            last.getNext().getNext().setPrevious(last);
            last.setNext(last.getNext().getNext());
            tmp.setNext(null);
            tmp.setPrevious(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        }
        if (last.getNext() == last) {
            last.setNext(null);
            last.setPrevious(null);
            last = null;
        } else {
            Node<E> tmp = last;
            last.getPrevious().setNext(last.getNext());
            last.getNext().setPrevious(last.getPrevious());
            last = last.getPrevious();
            tmp.setNext(null);
            tmp.setPrevious(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vacia");
        }
        return last.getNext().getData();
    }

   
    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Lista vacia");
        }
        return last.getData();
    }

    @Override
    public boolean insert(int index, E el) {
        if (el == null) {
            return false;
        }
        if (index >= efectivo || index < 0 || isEmpty()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Node<E> n = new Node<>(el);
        Node<E> j = last.getNext();
        int cuentaNodo = 0;
        do {
            if (cuentaNodo == index) {
                n.setNext(j);
                n.setPrevious(j.getPrevious());
                j.getPrevious().setNext(n);
                j.setPrevious(n);
                efectivo++;
                return true;
            }
            cuentaNodo++;
            j = j.getNext();
        } while (j != last.getNext());
        return true;
    }

    @Override
    public boolean contains(E el) {
        if (isEmpty() || el == null) {
            return false;
        }
        if (last.getNext() == last) {
            return getLast().equals(el);
        }
        return contains(el, last.getNext(), last);
    }

    private boolean contains(E element, Node<E> start, Node<E> end) {
        if (start.getData().equals(element) || end.getData().equals(element)) {
            return true;
        }
        if (start.getPrevious() == end.getNext() || (start.getPrevious() == end && end != last)) {
            return false;
        }
        return contains(element, start.getNext(), end.getPrevious());
    }

    @Override
    public E get(int index) {
        if (index >= efectivo || isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Indice no valido");
        }
        int cuentaNodo = 0;
        Node<E> j = last.getNext();
        do {
            if (cuentaNodo == index) {
                return j.getData();
            }
            cuentaNodo++;
            j = j.getNext();
        } while (j != last.getNext());
        return null;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo!");
        }
        if (isEmpty()) {
            return -1;
        }
        int cuentaNodo = 0;

        Node<E> j = last.getNext();
        do {
            if (j.getData().equals(element)) {
                return cuentaNodo;
            }
            cuentaNodo++;
            j = j.getNext();
        } while (j != last.getNext());

        return -1;
    }

    @Override
    public E remove(int index) {
        E removido = null;
        if (index >= efectivo || index < 0) {
            throw new IndexOutOfBoundsException("Excepcion en remove por arreglo vacio o indice fuera de rango");
        }
        if (index == 0) {
            removido = getFirst();
            removeFirst();
        } else if (index == efectivo - 1) {
            removido = getLast();
            removeLast();
        } else {
            Node<E> j = last.getNext();
            for (int i = 1; i < index; i++) {
                j = j.getNext();
            }
            removido = j.getNext().getData();
            Node<E> temp = j.getNext();
            j.getNext().getNext().setPrevious(j);
            j.setNext(j.getNext().getNext());
            temp.setData(null);
            temp.setNext(null);
            temp.setPrevious(null);
            efectivo--;
        }
        return removido;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public boolean remove(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        if (last.getNext() == last) {
            if (getLast().equals(element)) {
                last.setNext(null);
                last.setPrevious(null);
                last = null;
                efectivo--;
                return true;
            }
        } else {
            if (last.getNext().equals(element)) {
                removeFirst();
                return true;
            }
        }
        return remove(element, last.getNext().getNext(), last);
    }

    private boolean remove(E element, Node<E> start, Node<E> end) {
        Node<E> tmp = null;
        if (start.getData().equals(element)) {
            tmp = start;
        }
        if (end.getData().equals(element)) {
            tmp = end;
        }
        if (tmp != null) {
            tmp.getNext().setPrevious(tmp.getPrevious());
            tmp.getPrevious().setNext(tmp.getNext());
            tmp.setNext(null);
            tmp.setPrevious(null);
            tmp.setData(null);
            efectivo--;
            return true;
        } else {
            if ((start.getPrevious() == end.getNext() || (start.getPrevious() == end)) && end != last) {
                return false;
            }
            return remove(element, start.getNext(), end.getPrevious());

        }
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo!");
        }
        if (index >= efectivo || isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException("Indice incorrecto!");
        }
        int cuentaNodo = 0;
        Node<E> j = last.getNext();
        do {
            if (cuentaNodo == index) {
                E temp = j.getData();
                j.setData(element);
                return temp;
            }
            cuentaNodo++;
            j = j.getNext();
        } while (j != last.getNext());
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof DoublyCircularList)) {
            return false;
        }
        DoublyCircularList<E> other = (DoublyCircularList<E>) o;
        if (this.size() != other.size()) {
            return false;
        }
        Node<E> j = other.last;
        Node<E> i = last;
        if (i != null) {
            do {
                if (!(i.getData().equals(j.getData()))) {
                    return false;
                }
                j = j.getNext();
                i = i.getNext();
            } while (i != last);
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (!isEmpty()) {
            Node<E> i = last.getNext();
            do {
                if (i != null) {
                    s.append(i.getData());
                    if (!i.equals(last)) {
                        s.append(",");
                    }
                    i = i.getNext();
                } else {
                    s.append(getLast());
                }
            } while (i != last.getNext());
        }
        s.append("]");
        return s.toString();
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private Node<E> p = last;
            private boolean iniciado = false;

            @Override
            public boolean hasNext() {
                if(p != null){
                    if (iniciado)
                        return (p != last);
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                if(p == last)
                    iniciado = true;
                E data = p.getNext().getData();
                p = p.getNext();
                return data;
            }
        };
        return it;
    }
    
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> it = new ListIterator<E>() {
            private Node<E> p = getNode(index);
            private int currentIndex = index;
                    
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E data = p.getData();
                p = p.getNext();
                if(currentIndex == efectivo-1)
                    currentIndex = 0;
                else
                    currentIndex++;
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return p != null;
            }

            @Override
            public E previous() {
                E data = p.getData();
                p = p.getPrevious();
                if(currentIndex == 0)
                    currentIndex = efectivo - 1;
                else
                    currentIndex--;
                return data;
            }

            @Override
            public int nextIndex() {
                if(currentIndex == efectivo - 1)
                    return 0;
                return currentIndex+1;
            }

            @Override
            public int previousIndex() {
                if(currentIndex == 0)
                    return efectivo - 1;
                return currentIndex-1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        return it;
    }
    
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    private Node<E> getNode(int index) {
        if(isEmpty()) return null;
        if (index == 0) {
            return last.getNext();
        }else if(last.getNext() != last){
            int cuentaNodo = 1;
            Node<E> j = last.getNext().getNext();
            do{
                if (cuentaNodo == index) {
                    return j;
                }
                cuentaNodo++;
                j = j.getNext();
            }while(j != last.getNext().getNext());
        }
        return null;
    }
}
