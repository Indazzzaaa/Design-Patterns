package DSA.LinkedList.Nodes;

import java.util.Objects;

public class Node<T> {

    private T data;
    private Node<T> fwdRef;

//    public Node(){}

    public Node(T tValue){
        this.data = tValue;

    }

    public Node(T tValue, Node<T> ref){
        this(tValue);
        this.fwdRef = ref;
    }

    public void setFwdRef(Node<T> newRef){
        fwdRef = newRef;
    }

    public Node<T> getFwdRef(){
        return fwdRef;
    }

    public T getData(){
        return data;
    }





    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Node<?>)) return false;
        var other = (Node<T>) obj;
        return   (data == other.data) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, fwdRef);
    }

    @Override
    public String toString() {
        return String.format("Node(%s)", data);
    }
}
