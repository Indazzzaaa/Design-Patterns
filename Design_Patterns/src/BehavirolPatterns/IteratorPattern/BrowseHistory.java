package BehavirolPatterns.IteratorPattern;

import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class BrowseHistory {
    private final Stack<String> urls = new Stack<>();

    public void push(String url) {urls.push(url);}

    public String pop(){return urls.pop();}

    public Iterator<String> createIterator()
    {
        return new StackIterator(this);
    }


    // region : -- StackIterator

    private class StackIterator implements Iterator<String>
    {
        private final BrowseHistory history;
        private int index;

        public StackIterator(BrowseHistory history) {this.history = history;}



        @Override
        public boolean hasNext() {return index<history.urls.size();}

        @Override
        public String current() {return history.urls.get(index);}

        @Override
        public void next() { index++;}
    }

    // endregion
}
