package BehavirolPatterns.IteratorPattern;

public interface Iterator <T> {

    boolean hasNext();
    T current();
    void next();
}
