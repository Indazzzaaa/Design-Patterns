package Core.Advanced.Generics.Functionalnterface;

interface Cout<T> {
    public void print(T value);

}

interface TestOuterScope{
    public void outerScopeTest();
}

class Point{

    public int x, y;

    public void increment(){
        x++;
        y++;

        System.out.printf("P(%d,%d)\n",x,y);
    }


}


public class LambdaDemo {

    static int age =10;





    public static void Test() {
        Point p = new Point();

        int a =10;
        Cout<Integer> cout = value -> {
            age++;
            System.out.println(age);
        };

        TestOuterScope test = p::increment;
        test.outerScopeTest();

        cout.print(1);
        cout.print(2);
        cout.print(3);
        cout.print(4);


    }


}