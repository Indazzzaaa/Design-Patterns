package ChainOfResponsibility;

public class Compressor extends Handler{
    public Compressor(Handler next) {
        super(next);
    }

    @Override
    protected boolean doHandle(HttpRequest request) {
        System.out.println("->> Compressed");

        return false;
    }
}
