package threads;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class SquareCalculatorUsingFuturesTest {
    @Test
    public void testSquareCalculator() throws InterruptedException, ExecutionException {
        SquareCalculatorUsingFutures squareCalculatorUsingFutures = new SquareCalculatorUsingFutures ();
        Future<Integer> future = squareCalculatorUsingFutures.calculate ( 10);
        showResult ( future );
    }

    @Test
    public void testMultipleSqaureCalculations() throws ExecutionException, InterruptedException {
        SquareCalculatorUsingFutures c1 = new SquareCalculatorUsingFutures ();
        SquareCalculatorUsingFutures c2 = new SquareCalculatorUsingFutures ();
        Future<Integer> future1 = c1.showResult ( 20 );
        System.out.println ( "Second one goes here" );
        Future<Integer> future2 = c2.showResult( 10 );
        showResult ( future1 );
        showResult ( future2 );

    }

    private void showResult(Future<Integer> future) throws InterruptedException, ExecutionException {
        StopWatch watch = new StopWatch ();
        watch.start ();
        Integer result = future.get();
        watch.stop ();
        System.out.println ( result.toString ( ) +" Time = "+watch.toString ());
    }
}