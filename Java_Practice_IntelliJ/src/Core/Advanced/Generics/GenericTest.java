package Core.Advanced.Generics;

public class GenericTest {
    public static void GenericListTest(){

        var list = new GenericList<Integer>();
        list.addMany(1,2,3,4,5);
        System.out.println(list);
        System.out.println(list.size());
        list.clear();

        System.out.println(list);
        System.out.println(list.size());


    }
}
