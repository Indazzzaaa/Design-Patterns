package CommandPattern.editor;

public class ItalicCommand implements  UndoableCommand{

    private String prevContent;
    private final HTMLDocument document;
    private final History history;

    public ItalicCommand( HTMLDocument document, History history) {
        this.document = document;
        this.history = history;
    }


    @Override
    public void unexecute() {
        document.setContent(prevContent);
        System.out.println("->> Undo : ItalicCommand");
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        this.makeItalic();
        history.push(this);
    }

    private void makeItalic(){
        document.setContent( String.format("->> Italic: %s",prevContent));

    }
}
