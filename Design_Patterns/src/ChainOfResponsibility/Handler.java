package ChainOfResponsibility;

public abstract class Handler {
    private final Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public void handle(HttpRequest request){

        // this is to check if current handle is executed successfully
        if (doHandle(request)) return;

        if(next!=null) next.handle(request);

    }

    protected abstract  boolean doHandle(HttpRequest request);
}
