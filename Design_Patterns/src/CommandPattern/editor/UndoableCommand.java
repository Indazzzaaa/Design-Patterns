package CommandPattern.editor;


public interface UndoableCommand extends Command {
    void unexecute();

}
