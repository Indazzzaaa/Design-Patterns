package BehavirolPatterns.CommandPattern;

import BehavirolPatterns.CommandPattern.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("->> Resized applied");
    }
}
