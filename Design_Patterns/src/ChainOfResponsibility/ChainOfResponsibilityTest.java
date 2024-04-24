package ChainOfResponsibility;

public class ChainOfResponsibilityTest {
    public static void test(){
        // we want to create processing pipeline like this
        // authenticator -> logger -> compressor
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);
        server.handle(new HttpRequest("admin","1234"));
    }

    // now it's easily extensible
    public static void test2(){
        // decrypter -> authenticator -> encrypter -> logger -> compressor
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var encrypter = new Encrypter(logger);
        var authenticator = new Authenticator(encrypter);
        var decrypter = new Decrypter(authenticator);

        var server = new WebServer(decrypter);
        server.handle(new HttpRequest("admin","1234"));
    }
}
