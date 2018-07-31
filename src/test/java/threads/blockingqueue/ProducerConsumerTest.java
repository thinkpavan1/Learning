package threads.blockingqueue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.*;

public class ProducerConsumerTest {
    @Test
    public void testProducerConsumer() throws InterruptedException {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<Message> ( 10 );
        Producer producer = new Producer ( queue );
        Consumer consumer = new Consumer ( queue );

        new Thread(producer).start ();
        new Thread(consumer).start ();
        System.out.println ( "Producer and consumer have been started" );

        sleep(5000);
    }

}