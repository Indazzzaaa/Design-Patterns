package Core.Oops.Inheritance;

public class TestInheritance {
    public static void Test(){

        System.out.println("Testing Started!!");



        var smallRectangle = new Rectangle("Small Rectangle");
        var bigRectangle = new Rectangle("Big Rectangle");
        System.out.printf("Total Rectangle Created : %d\n",Shape.getShapeCount());
        System.out.println(smallRectangle);
        System.out.println(bigRectangle);


        System.out.println("Testing Ended!!");


    }

    public static void Test2(){
        System.out.println("Testing Started !!");

        var smallEllipse = new Ellipse("Small Ellipse");
        var bigCircle = new Ellipse("Big Circle");
        System.out.printf("Total Ellipse Created: %d \n",Ellipse.getEllipseCount());
        System.out.println(smallEllipse);
        System.out.println(bigCircle);



        System.out.println("Testing Ended !!");
    }
}
