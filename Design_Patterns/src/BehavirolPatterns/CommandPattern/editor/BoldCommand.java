package BehavirolPatterns.CommandPattern.editor;

public class BoldCommand implements  UndoableCommand {

    private String prevContent;
    private final HTMLDocument document;
    private final History history;

    public BoldCommand( HTMLDocument document, History history) {
        this.document = document;
        this.history = history;
    }


    @Override
    public void unexecute() {
        document.setContent(prevContent);
        System.out.println("->> Undo : BoldCommand");
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        this.makeBold();
        history.push(this);
    }

    private void makeBold(){
        document.setContent( String.format("->> Bold: %s",prevContent));

    }
}
