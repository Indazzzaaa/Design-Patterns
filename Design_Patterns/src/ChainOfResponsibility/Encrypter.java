package ChainOfResponsibility;

public class Encrypter extends Handler{
    public Encrypter(Handler next) {
        super(next);
    }

    @Override
    protected boolean doHandle(HttpRequest request) {
        System.out.println("->> Encrypter");
        return false;
    }
}
