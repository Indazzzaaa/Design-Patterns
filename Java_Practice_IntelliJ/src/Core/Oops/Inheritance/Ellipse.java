package Core.Oops.Inheritance;

public class Ellipse implements  IShape{

    private static int ellipseCount;
    private final String name;

    public Ellipse(String name){
        this.name = name;
        ellipseCount++;
    }

    public static int getEllipseCount() {
        return ellipseCount;
    }


    @Override
    public void render() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Ellipse{name = '%s'}",name);



    }
}
