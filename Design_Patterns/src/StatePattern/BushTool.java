package StatePattern;

public class BushTool implements Tool{

    @Override
    public void mouseUp() {
        System.out.printf("->> %s de-selected%n","Tool: Brush");
    }

    @Override
    public void mouseDown() {

        System.out.printf("->> %s Selected%n","Tool: Brush");
    }
}
