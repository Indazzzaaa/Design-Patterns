package CommandPattern.fx;

public class Button {
    private String label;
    private final Command command;

    public Button(Command command) {
        this.command = command;
    }

    // this acting like the UI interface where user press the button
    public void click(){
        command.execute();
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
