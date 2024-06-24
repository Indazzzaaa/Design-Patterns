package StructrualPatterns.Composite;

public class CompositePatternTest {
    public static void run(){
        Group g1 = new Group();
        Group g2 = new Group();

        Shape circle = new Shape("Circle");
        Shape square = new Shape("Square");
        Shape line = new Shape("Straight Line");

        g1.add(circle);
        g1.add(line);

        g2.add(square);
        g2.add(line);

        Group group = new Group();
        group.add(g1);
        group.add(g2);
        group.render();



    }
}
