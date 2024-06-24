package BehavirolPatterns.CommandPattern;

import BehavirolPatterns.CommandPattern.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("->> B&W applied");
    }
}
