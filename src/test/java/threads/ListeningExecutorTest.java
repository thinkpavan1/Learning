package threads;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ListeningExecutorTest {

    @Test
    public void testListeningExecutor() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool ( );
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator ( executorService );
        ListenableFuture<String> future1 = listeningExecutorService.submit ( ()-> "Hello" );
        ListenableFuture<String> future2 = listeningExecutorService.submit ( ()-> "World" );

        String message = Futures.allAsList (future1, future2 ).get().stream ().collect( Collectors.joining (" "));

        assertEquals(message, "Hello World");
    }

}
