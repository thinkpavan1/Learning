package threads;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculatorUsingFutures {
    ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator ( Executors.newSingleThreadExecutor ( ) );
    private ExecutorService executor = Executors.newSingleThreadExecutor ( );

    public Future<Integer> calculate(Integer input) {
        return listeningExecutorService.submit ( () -> {
            return actualComputation ( input );
        } );
    }

    private int actualComputation(int input) throws InterruptedException {
        System.out.println ( "Started calculating for " + input );
        Thread.sleep ( input * 100 );
        System.out.println ( "done for " + input + " Thread name = "+Thread.currentThread ().getName ());
        return input * input;
    }

    public Future<Integer> showResult(int input) {
        return calculate ( input );
    }
}
