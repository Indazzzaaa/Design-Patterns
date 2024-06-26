package BehavirolPatterns.Mediator;

public class ArticlesDialogBox extends  DialogBox {

    private final ListBox articlesListBox = new ListBox(this);
    private final TextBox titleTextBox = new TextBox(this);
    private final Button saveButton = new Button(this);

    @Override
    public void changed(UIControl control) {
    if (control == articlesListBox) articleSelected();
    else if (control == titleTextBox) titleChanged();


    }

    private void titleChanged(){
        var content = titleTextBox.getContent();
        var isEmpty = (content==null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }

    private void articleSelected(){
        titleTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }

    // [This is just for testing]
    public void simulateUserInteraction(){
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("");
        titleTextBox.setContent("Article 2");
        System.out.println("->> TexBox: " + titleTextBox.getContent());
        System.out.println("->> Button enabled: " + saveButton.isEnabled());
    }
}
