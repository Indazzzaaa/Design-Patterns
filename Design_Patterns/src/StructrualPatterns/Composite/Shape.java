package StructrualPatterns.Composite;

public class Shape implements Components {

    String name;
    public Shape(String name){
        this.name = name;
    }


    @Override
    public void render() {
        System.out.printf("->> Rendering : %s\n",name);
    }
}
