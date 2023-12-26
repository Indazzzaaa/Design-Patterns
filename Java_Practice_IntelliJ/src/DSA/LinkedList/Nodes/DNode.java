package DSA.LinkedList.Nodes;

import java.util.Objects;

public class DNode<T> extends  Node<T> {

    private DNode<T> backRef;
    public DNode(T value){
         super(value);
    }

    public DNode(T value, DNode<T> fwdRef){
        super(value,fwdRef);
    }

    public DNode(T value, DNode<T> fwdRef, DNode<T> backRef){
        super(value,fwdRef);
        this.backRef = backRef;
    }

    public DNode<T> getBackRef(){
        return backRef;
    }

    public void setBackRef(DNode<T> backRef){
        this.backRef = backRef;
    }


    public  DNode<T> getFwdRef(){
        return (DNode<T>) super.getFwdRef();
    }


    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof DNode<?>)) return false;
        var other = (DNode<T>) obj;
        return   (this.getData() == other.getData()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getData(), this.getFwdRef(),this.getBackRef());
    }



    @Override
    public String toString() {

        return String.format("DNode(%s)",getData());

    }
}
