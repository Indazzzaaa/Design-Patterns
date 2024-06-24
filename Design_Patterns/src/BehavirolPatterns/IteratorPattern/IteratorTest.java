package BehavirolPatterns.IteratorPattern;

public class IteratorTest {
    public static void test(){
        var history = new BrowseHistory();
        history.push("www.google.com");
        history.push("www.meta.com");
        history.push("www.instagram.com");
        history.push("www.twitter.com");
        history.push("www.youtube.com");
        history.push("www.chatgpt.com");

        var iterator = history.createIterator();

        while (iterator.hasNext()) {
            var url = iterator.current();
            System.out.printf("->> visiting: %s\n",url);
            iterator.next();
        }
    }
}
