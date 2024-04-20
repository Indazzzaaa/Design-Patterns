package Strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.printf("->> Applying B&W filter on file : %s\n",fileName);
    }
}
