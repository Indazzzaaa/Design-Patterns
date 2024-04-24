package ChainOfResponsibility;

public class Decrypter extends Handler{
    public Decrypter(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        System.out.println("->> Decrypter");
        return false;
    }
}
