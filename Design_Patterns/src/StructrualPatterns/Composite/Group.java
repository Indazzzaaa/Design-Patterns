package StructrualPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Components{

    private final List<Components> componentsList= new ArrayList<>();


    public void add(Components comp){
        componentsList.add(comp);
    }

    @Override
    public void render() {
        for(var comp : componentsList)
            comp.render();

    }
}
