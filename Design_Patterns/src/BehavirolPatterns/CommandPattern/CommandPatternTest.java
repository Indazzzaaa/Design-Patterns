package BehavirolPatterns.CommandPattern;

import BehavirolPatterns.CommandPattern.editor.*;
import BehavirolPatterns.CommandPattern.fx.Button;

public class CommandPatternTest {
    public static void test(){
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }

    public static void CompositeTest(){
        var composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add(new BlackAndWhiteCommand());
        composite.execute();

    }

    public static void UndoableTest(){
        var history = new History();
        var document = new HTMLDocument();
        document.setContent("Hello World");

        var boldCommand = new BoldCommand(document,history);
        boldCommand.execute();
        System.out.println(document.getContent());

        var italicCommand = new ItalicCommand(document,history);
        italicCommand.execute();
        System.out.println(document.getContent());

        // undo the previous commands.
        var undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());
        undoCommand.execute();
        System.out.println(document.getContent());
    }
}
