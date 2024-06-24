package BehavirolPatterns.StatePattern;

public class StatePatternTest {
    public static void test(){

        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new BushTool());
        canvas.mouseDown();
        canvas.mouseUp();



    }
}
