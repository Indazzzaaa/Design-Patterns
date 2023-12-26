package DSA.LinkedList;


import DSA.LinkedList.Manager.DoublyLL;
import DSA.LinkedList.Manager.SinglyLL;

public class LLTest {
    public static void testMain(){
        var doublyLL = new DoublyLL<Integer>(1,1,2,3,4,5);
        doublyLL.removeFirst();
        doublyLL.removeLast();

        doublyLL.addFirst(10);
        doublyLL.addLast(-10);
        System.out.println(doublyLL);
        System.out.println(doublyLL.getSize());
        System.out.println(doublyLL.get(5));



    }

    public static void test1(){
        var singlyLL = new SinglyLL<Integer>();

        singlyLL.add(1);
        singlyLL.add(2);
        singlyLL.add(3);
        singlyLL.addFirst(10);
        singlyLL.addFirst(20);
        singlyLL.addLast(-20);
        singlyLL.addLast(-10);


        System.out.println(singlyLL);
        System.out.println(singlyLL.getHead().getFwdRef());
        System.out.println(singlyLL.getSize());

        singlyLL.removeFirst();
        singlyLL.removeLast();
        System.out.println(singlyLL);
        System.out.println(singlyLL.getSize());
    }

}
