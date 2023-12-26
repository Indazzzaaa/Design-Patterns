package DSA.LinkedList.Manager;

import DSA.LinkedList.Nodes.DNode;

import java.util.Iterator;

public class DoublyLL<T> implements Iterable<DNode<T>> {

    private int size;
    private DNode<T> head;
    private DNode<T> tail;


    public DoublyLL() {}


    @SafeVarargs
    public DoublyLL(T... tValues) {
        for (var tValue : tValues)
            add(tValue);

    }

    public int getSize() {
        return size;
    }

    public DNode<T> getHead() {
        return head;
    }

    public DNode<T> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T tValue) {
        addLast(tValue);


    }

    public DNode<T> get(int index) {
        if (index < 0) throw new IllegalArgumentException("Index can't be negative.");
        if (index >= size)
            throw new IndexOutOfBoundsException(String.format("Provided index : %d , Can Search Upto Index : %d", index, size - 1));


        DNode<T> trav = head;
        if (size != 1) {

            int currIndex = 0;
            while (currIndex < index) {
                trav = trav.getFwdRef();
                currIndex++;
            }
        }


        return trav;


    }


    public void addFirst(T elem) {
        if (elem == null) return;
        if (isEmpty()) {
            head = tail = new DNode<>(elem);
        } else {
            head = new DNode<>(elem, head);
        }
        size++;
    }

    public void addLast(T elem) {
        if (elem == null) return;
        if (isEmpty()) {
            head = tail = new DNode<>(elem);
        } else {
            tail.setFwdRef(new DNode<>(elem,null,tail));
            tail = tail.getFwdRef();
        }
        size++;
    }

    public DNode<T> removeFirst() {
        if (isEmpty()) return null;

        var temp = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = temp.getFwdRef();
            head.setBackRef(null);

        }
        size--;
        return temp;


    }

    public DNode<T> removeLast() {

        if (isEmpty()) return null;
        var temp = head;
        if (size == 1) {
            head = tail = null;


        } else {

            temp = tail;
            tail = tail.getBackRef();
            tail.setFwdRef(null);
        }

        size--;
        return temp;


    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DoublyLL<?>) || (size != ((DoublyLL<?>) obj).size)) return false;
        if (obj == this) return true;

//        now at state where we are sure both will be of equal size
        var otherDoublyLL = (DoublyLL<T>) obj;
        for (int i = 0; i < size; i++) {

            if (!get(i).equals(otherDoublyLL.get(i))) return false;

        }


        return true;

    }

    @Override
    public Iterator<DNode<T>> iterator() {
        return new Iterator<>() {
            private DNode<T> trav = head;

            @Override
            public boolean hasNext() {


                return trav != null;
            }

            @Override
            public DNode<T> next() {
                var temp = trav;
                trav = trav.getFwdRef();

                return temp;
            }

        };
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "(Head,Tail)-->null";
        }


        StringBuilder builder = new StringBuilder();
        builder.append("null<--");
        for (var node : this) {
            builder.append(node).append("<-->");
        }
        builder.append("🚫null");

        return builder.toString();
    }
}
