package threads.negativeresponses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DBObject {

    ExecutorService service = Executors.newSingleThreadExecutor ();

    public Future<Integer> getAsynLength(String input) throws InterruptedException {
        System.out.println ( "In Asyn Length for " + input );
        Future<Integer> future = service.submit ( () -> {
           return getLength ( input );
        });
        return future;
    }

    public int getLength(String input) throws InterruptedException {
        System.out.println ( "In length for input " + input );
        Thread.sleep(1000);
        System.out.println ( "Compled processing for " + input +" Thread name = "+Thread.currentThread ().getName ());
        return input.length ();
    }
}
