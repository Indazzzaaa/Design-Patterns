package ChainOfResponsibility;

public abstract class Handler {
    private Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public void handle(HttpRequest request){

        // this is to check if current handle is executed successfully
        if (doHandle(request)) return;

        if(next!=null) next.handle(request);

    }

    public abstract  boolean doHandle(HttpRequest request);
}
