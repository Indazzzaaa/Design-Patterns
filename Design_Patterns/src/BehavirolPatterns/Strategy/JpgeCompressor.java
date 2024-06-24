package BehavirolPatterns.Strategy;

public class JpgeCompressor implements Compressor{
    @Override
    public void compress(String fileName) {
        System.out.printf("->> Compressing File: %s using jpeg compressor\n",fileName);
    }
}
