package Core.Advanced.ThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main() throws InterruptedException{

        executorTest();
        System.out.println("[Program Completed]");


    }

    private static void executorTest(){
        try(var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())){
            int tasksCount = 1_000_000;
            for(int i=0;i++<tasksCount;){
                executor.submit(new FileDownload());
            }
        }
    }

    private  static void virtualThreadDemo(){
        for(int i=0;i++<10_000_000;){
//            JVM take heap size of 4gb if it crosss it will throw OutOfMemoryException
            Thread thread = Thread.startVirtualThread(new FileDownload());
           /* Thread thread = new Thread(new FileDownload());
            thread.start();*/
        }
    }

    private static void tenBillionSum(){
        final long tenBillion = (long)Math.pow(10,10);
        long sum = 0;
        long startTime = System.currentTimeMillis();
        for(long i=1;i<tenBillion;i++){
            sum+=i;
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.printf(" [%s,%dms], Sum : %,d\n",Thread.currentThread().getName(),executionTime,sum);



    }


    private static void oneBillionSum(){

        final int oneBillion = (int)Math.pow(10,9);
        long sum = 0;
        long startTime = System.currentTimeMillis();
        for(int i=1;i<oneBillion;i++){
            sum+=i;
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.printf(" [%s,%dms], Sum : %,d\n",Thread.currentThread().getName(),executionTime,sum);



    }

    private static void threadDemo(){


        for(var i=0;i++<10;){
            Thread thread = new Thread(new FileDownload());
            thread.start();
        }


    }


    private static void threadInfo(){
        System.out.println("Total active threads: "+Thread.activeCount());
        System.out.println("Total available process: " + Runtime.getRuntime().availableProcessors());

        System.out.println(Thread.ofPlatform());
    }

    private  static void memoryProfiler() throws InterruptedException{

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        // Get the memory MXBean
        // Get the heap memory usage
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Heap Memory Usage: " + formatMemoryUsage(heapMemoryUsage));

        // Get the non-heap memory usage
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("Non-Heap Memory Usage: " + formatMemoryUsage(nonHeapMemoryUsage));
        // Perform some tasks that may consume memory

//        ------------------------------------ Put code here ---------------------------------





        // Print memory usage again after some tasks
        heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("Heap Memory Usage after tasks: " + formatMemoryUsage(heapMemoryUsage));

        nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        System.out.println("Non-Heap Memory Usage after tasks: " + formatMemoryUsage(nonHeapMemoryUsage));

    }

    private static String formatMemoryUsage(MemoryUsage memoryUsage) {
        final float mb = 1024*1024;
        return String.format(
                "Init: %.2f MB, Used: %.2f MB, Committed: %.2f MB, Max: %.2f MB",
                memoryUsage.getInit() / mb,
                memoryUsage.getUsed() / mb,
                memoryUsage.getCommitted() / mb,
                memoryUsage.getMax() / mb
        );
    }

}
