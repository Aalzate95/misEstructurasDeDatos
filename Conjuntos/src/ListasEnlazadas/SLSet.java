package ListasEnlazadas;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Alexa
 */
public class SLSet<E> {
    private LinkedList<E> list;
    private Comparator<E> f;
    
    public SLSet(Comparator<E> f){
        list = new LinkedList<>();
        this.f = f;
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public boolean add(E element){
        if(element == null)
            return false;
        else if(list.isEmpty())
            return list.add(element);
        else if (f.compare(element, list.getLast())>0)
            return list.add(element);
        ListIterator<E> it = list.listIterator();
        while (it.hasNext()){
            E data = it.next();
            if(f.compare(data, element) == 0)
                return false;
            else if(f.compare(data, element) > 0){
                it.previous();
                it.add(element);
                return true;
            }
        }return true;
    }
    
    public boolean remove(E element){
        if (element == null || list.isEmpty())
            return false;
        else if(f.compare(element, list.getLast())==0)
            return list.remove(element);
        ListIterator<E> it = list.listIterator();
        while (it.hasNext()){
            E data = it.next();
            if(f.compare(data, element)>0 || f.compare(data, element)<0)
                return false;
            else if (f.compare(data, element) == 0){
                it.previous();
                return list.remove(element);
            }
        }return true;
    }
    
    public SLSet Union(SLSet<E> s){
        SLSet result = new SLSet(f);
        if(this.isEmpty() || s.isEmpty())
            return result;
        ListIterator<E> it1 = s.list.listIterator();
        ListIterator<E> it2 = this.list.listIterator();
        while(it1.hasNext() || it2.hasNext()){
            E data1 = it1.next();
            E data2 = it2.next();
            if (f.compare(data1, data2) < 0){
                it2.previous();
                result.list.add(data1);
            }else if (f.compare(data1, data2) > 0){
                it1.previous();
                result.list.add(data2);
            }else
                result.list.add(data1);
        }return result;
    }
    
    public SLSet Interception(SLSet<E> s){
        SLSet result = new SLSet(f);
        if(this.isEmpty() || s.isEmpty())
            return result;
        ListIterator<E> it1 = s.list.listIterator();
        ListIterator<E> it2 = this.list.listIterator();
        while(it1.hasNext() && it2.hasNext()){
            E data1 = it1.next();
            E data2 = it2.next();
            if (f.compare(data1, data2) < 0)
                it2.previous();
            else if (f.compare(data1, data2) > 0)
                it1.previous();
            else
                result.list.add(data1);
        }return result;        
    }
    
    public SLSet Diference(SLSet<E> s){
        SLSet result = new SLSet(f);
        if(this.isEmpty())
            return result;
        ListIterator<E> it1 = s.list.listIterator();
        ListIterator<E> it2 = this.list.listIterator();
        while(it1.hasNext() || it2.hasNext()){
            E data1 = it1.next();
            E data2 = it2.next();
            if (f.compare(data1, data2) < 0){
                it2.previous();
                result.list.add(data1);
            }else if (f.compare(data1, data2) > 0)
                it1.previous();
            else {
            }
        }return result;
    }
}
