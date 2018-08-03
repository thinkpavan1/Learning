package threads.blockingqueue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class ProducerConsumerFunctionsTest {
    private BlockingQueue<Message> queue = new ArrayBlockingQueue<Message> ( 3 );

    @Test
    public void testProducerConsumer() throws InterruptedException {
        produceMessages ();
        consumeMessages ();

        System.out.println ( "Producer and consumer have been started" );

        Thread.sleep(5000);
    }

    private void produceMessages() {
        new Thread ( () -> {
            try {
                for (int index = 0; index < 10; index++) {
                    Message message = new Message ( Integer.toString ( index ) );
                    queue.put ( message );
                    System.out.println ( "Produced " + message );
                    Thread.sleep ( 10 );
                }
                queue.put(new Message ( "exit" ));
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
        } ).start ();
    }

    private void consumeMessages(){
        new Thread(() -> {
            try {
                Message message = null;
                while((message = queue.take ()).getMessage () != "exit"){
                    Thread.sleep(10);
                    System.out.println ( "Consumed " + message.getMessage ( ) );
                }
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
        }).start ();
    }
}

