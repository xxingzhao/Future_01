package org.xiaoxz.block;

import java.util.concurrent.BlockingQueue;

public class Cunsumer implements Runnable {

    private BlockingQueue blockingQueue;

    public Cunsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            System.out.println(this.blockingQueue.take());
            System.out.println(this.blockingQueue.take());
            System.out.println(this.blockingQueue.take());
        } catch(Exception e) {
          e.printStackTrace();
        }
    }
}
