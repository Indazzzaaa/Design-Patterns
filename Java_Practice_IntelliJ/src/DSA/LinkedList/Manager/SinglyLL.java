package DSA.LinkedList.Manager;

import DSA.LinkedList.Nodes.Node;

import java.util.Iterator;

public class SinglyLL<T> implements Iterable<Node<T>> {

    private int size;
    private Node<T> head;
    private Node<T> tail;


    public SinglyLL() {
    }


    @SafeVarargs
    public SinglyLL(T... tValues) {
        for (var tValue : tValues)
            add(tValue);

    }

    public int getSize() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T tValue) {
        addLast(tValue);


    }

    public Node<T> get(int index) {
        if (index < 0) throw new IllegalArgumentException("Index can't be negative.");
        if (index >= size)
            throw new IndexOutOfBoundsException(String.format("Provided index : %d , Can Search Upto Index : %d", index, size - 1));


        Node<T> trav = head;
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
            head = tail = new Node<>(elem);
        } else {
            head = new Node<>(elem, head);
        }
        size++;
    }

    public void addLast(T elem) {
        if (elem == null) return;
        if (isEmpty()) {
            head = tail = new Node<>(elem);
        } else {
            tail.setFwdRef(new Node<>(elem));
            tail = tail.getFwdRef();
        }
        size++;
    }

    public Node<T> removeFirst() {
        if (isEmpty()) return null;

        var temp = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = temp.getFwdRef();

        }
        size--;
        return temp;


    }

    public Node<T> removeLast() {

        if (isEmpty()) return null;
        var temp = head;
        if (size == 1) {
            head = tail = null;


        } else {
            var trev = temp;
            while (trev.getFwdRef().getFwdRef() != null) {
                trev = trev.getFwdRef();
            }
            temp = trev.getFwdRef();
            tail = trev;
            tail.setFwdRef(null);

        }

        size--;
        return temp;


    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SinglyLL<?>) || (size != ((SinglyLL<?>) obj).size)) return false;
        if (obj == this) return true;

//        now at state where we are sure both will be of equal size
        var otherSinglyLL = (SinglyLL<T>) obj;
        for (int i = 0; i < size; i++) {

            if (!get(i).equals(otherSinglyLL.get(i))) return false;

        }


        return true;

    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {


                return trav != null;
            }

            @Override
            public Node<T> next() {
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
        for (var node : this) {
            builder.append(node).append("-->");
        }
        builder.append("null");

        return builder.toString();
    }
}
