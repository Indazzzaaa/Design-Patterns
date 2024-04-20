package Strategy;

public class HighContrast implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.printf("->> Applying High contrast filter on file: %s\n",fileName);
    }
}
