package Core.Oops.Inheritance;

public abstract class Shape {

    private static int shapeCount;

    public Shape(){
        // this will always print which shape we are creating.

        System.out.print("Shape Created : ");

//        Here's the issue:
//        The subclass's fields might not be initialized yet because the subclass's constructor has not been called.
        // because super() is first keyword that is called.
//        System.out.println(this.render());

        shapeCount++;
    }


    public static int getShapeCount(){
        return shapeCount;
    }

    public abstract String render();





}
