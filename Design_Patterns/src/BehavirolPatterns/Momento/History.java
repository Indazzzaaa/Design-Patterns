package BehavirolPatterns.Momento;

import java.util.Stack;



public class History {
    private final Stack<EditorState> editorHistory;

    public History(){
        editorHistory = new Stack<>();
    }

    public void push(EditorState currState){
        editorHistory.push(currState);
    }

    // return previous saved state
    public EditorState pop() {

        int totalHistories = editorHistory.size();
        if( totalHistories==0) return null;

       return  editorHistory.pop();

    }






}
