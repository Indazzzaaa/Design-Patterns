package Core.Advanced.ThreadTest;

import java.util.concurrent.TimeUnit;

public class FileDownload implements Runnable{

    @Override
    public void run() {
        try {
//            Thread.sleep(2000);
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("File downloaded by Thread-[%d]\n",Thread.currentThread().threadId());
    }
}
