package Core.Advanced.Generics;

import java.util.Arrays;
import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {

    private T[] storage;
    private int len = 0;
    private int capacity;

    public GenericList() {
         this(4);

    }

    public GenericList(int size) {
        if(size<0) throw new IllegalArgumentException("Illegal Capacity " + capacity);
        capacity = size;
        storage = (T[]) new Object[capacity];
    }

    public int getCapacity(){
        return capacity;
    }

    public int size(){
        return len ;
    }

    public boolean isEmpty(){
        return  size() ==0;
    }


    public void add(T tValue) {
        if(tValue==null) return;

        if (len >= capacity) {
            // create another storage of double of it's size.
            capacity = capacity<<1;
            var tempStorage = (T[]) new Object[capacity];

            // copy data to new allocated space
            System.arraycopy(storage, 0, tempStorage, 0, (capacity>>1));
            storage = tempStorage;
        }
        storage[len++] = tValue;
    }


    @SafeVarargs
    public final void addMany(T... tValues){
        for(var tValue : tValues){
            add(tValue);
        }
    }



    public T get(int index) {
        if(index<0) throw  new IllegalArgumentException();
        if(index>=len) throw new IndexOutOfBoundsException();

        return  storage[index];


    }

    public void set(int index, T tValue) {
        if(index<0) throw new IllegalArgumentException();
        if (index >= len) throw new IndexOutOfBoundsException();

        storage[index] = tValue;

    }

    public boolean remove(int index) {
        // we are not throwing error.Just tell true or false .
        if ( index< 0 || index >= len) return false;

        // shift all elements back by 1 index.
        for (int i = index; i < len; i++) {
            storage[i] = storage[i + 1];
        }

        len--; // since one element is reduced .
        return true;


    }

    public void clear(){

        for(int i=0;i<len;i++)  {
            storage[i]=null;
        }
        len =0;
    }

    public int indexOf(Object obj){
        for(int i=0;i<len;i++){
            if(storage[i].equals(obj))
                return i;
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) !=-1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index =0;
            @Override
            public boolean hasNext() {
                return  index <= len;
            }

            @Override
            public T next() {
                return storage[index++];
            }
        };
    }

    @Override
    public String toString() {
        if(len==0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i=0;i<len-1;i++){
                sb.append(storage[i]).append(", ");

            }
            return sb.append(storage[len - 1]).append("]").toString();
        }
    }
}
