package Core.Oops.Inheritance;

public class Rectangle extends  Shape{
    private final String name;

    public Rectangle(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String render() {
        return this.name;
    }

    @Override
    public String toString() {
        return  String.format("Rectangle whose name is : %s",name);
    }
}
