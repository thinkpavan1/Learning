package threads.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final  BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        Message msg;
        try {
            while(!(msg = queue.take()).getMessage ().equals ( "exit" )){
                Thread.sleep(10);
                System.out.println ( "Consumed "+msg );
            }
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
    }
}
