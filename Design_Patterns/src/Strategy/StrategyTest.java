package Strategy;

public class StrategyTest {
    public static void test(){
        var imageStore = new ImageStorage();
        imageStore.store("a",new JpgeCompressor(),new BlackAndWhiteFilter());
        imageStore.store("b",new PngCompressor(),new HighContrast());
    }
}
