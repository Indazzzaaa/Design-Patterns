package Momento;

public class TestMomento {

    public static void test(){
        var editor = new Editor();
        var history = new History();

        editor.setContent("Sumant");
        history.push(editor.createState());

        editor.setContent("Vishal");
        history.push(editor.createState());

        editor.setContent("Rahul");
        history.push(editor.createState());

        System.out.printf("->> Current state : %s\n",editor.getContent());


    }
}
