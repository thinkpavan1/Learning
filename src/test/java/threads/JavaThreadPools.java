package threads;

import org.junit.Test;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class JavaThreadPools {
    @Test
    public void whenCreateSingleThreadExecutor_thenExecute(){
        Executor executor = Executors.newSingleThreadExecutor ( );
        executor.execute ( ()-> System.out.println("Hello World") );
    }

    @Test
    public void whenCreateSingleThreadExecutorFromExecutorService_thenExecute() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool ( 10 );
        Future<String> future = executorService.submit ( () -> "Hello World From Executor Service "  );
        String result =  future.get();
        System.out.println ( "Result From executor service = " + result );
    }

    @Test
    public void whenUsingTheadPoolExecutor_thenExecute() throws InterruptedException {
        ThreadPoolExecutor execute = (ThreadPoolExecutor )Executors.newFixedThreadPool ( 2 );
        execute.submit ( ()-> {
            System.out.println ( "first thread" );
            sleep ( 1000 );
            System.out.println ( "first thread ended" );
            return null;
        } );
        execute.submit ( ()-> {
            System.out.println ( "second thread" );
            sleep ( 1000 );
            System.out.println ( "Second thread ended" );
            return null;
        } );
        execute.submit ( ()-> {
            System.out.println ( "thrid thread" );
            sleep ( 1000 );
            System.out.println ( "third thread ended" );
            return null;
        } );

        assertEquals(2, execute.getPoolSize());
        assertEquals(1, execute.getQueue ().size ());

        Thread.currentThread ().join (2000);
    }

    @Test
    public void whenUsingCachedThreadPool_thenExecute() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool ();

        executor.submit ( ()-> {
            String threadName ="Cached Thread Pool First Thread";
            System.out.println ( threadName +" Started" );
            try {
                sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            System.out.println ( threadName +" Ended" );
        } );
        executor.submit ( ()-> {
            String threadName ="Cached Thread Pool Second Thread";
            System.out.println ( threadName +" Started" );
            try {
                sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            System.out.println ( threadName +" Ended" );
        } );
        executor.submit ( ()-> {
            String threadName ="Cached Thread Pool Third Thread";
            System.out.println ( threadName +" Started" );
            try {
                sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            System.out.println ( threadName +" Ended" );
        } );

        assertEquals(3, executor.getPoolSize());
        assertEquals(0, executor.getQueue ().size ());

    }

    @Test
    public void whenUsingScheduledThreadPool_thenScheduledAndExecuted() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch ( 3 );

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool ( 5 );
        ScheduledFuture<?> future =  scheduledExecutorService.schedule ( () -> {
            System.out.println(" Scheduled Hello World" );
        },500, TimeUnit.MILLISECONDS);
        System.out.println ( "Lets start " );
        countDownLatch.await (1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }
}
