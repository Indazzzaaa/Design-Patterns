package BehavirolPatterns.Strategy;

public class ImageStorage {
    // it can have states of compressor and filter , since don't need here we removed it.

    public void store(String filename, Compressor compressor,Filter filter){
        compressor.compress(filename);
        filter.apply(filename);
    }
}
