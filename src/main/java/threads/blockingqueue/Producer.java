package threads.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Message> queue;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int index = 0; index < 100; index++) {
                Message message = new Message ( Integer.toString ( index ) );
                Thread.sleep ( index );
                queue.put ( message );
                System.out.println ( "Produced " + message );
            }
                queue.put ( new Message ( "exit" ) );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
    }
}