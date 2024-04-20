package StatePattern;

public class SelectionTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.printf("->> %s de-selected%n","Tool: Selection");
    }

    @Override
    public void mouseDown() {
        System.out.printf("->> %s Selected%n","Tool: Selection");

    }
}
