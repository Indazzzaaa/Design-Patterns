package BehavirolPatterns.Strategy;

public class PngCompressor implements Compressor{
    @Override
    public void compress(String fileName) {
        System.out.printf("->> Compressing file: %s using png compressor\n",fileName);
    }
}
