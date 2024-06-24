package BehavirolPatterns.CommandPattern.editor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class History {
    private final Stack<UndoableCommand> commands = new Stack<>();

    public void push(UndoableCommand command) {commands.push(command);}

    public UndoableCommand pop() { return commands.pop();}

    public int size(){
        return commands.size();
    }
}
