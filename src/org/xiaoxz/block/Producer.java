package org.xiaoxz.block;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            this.blockingQueue.put("A");
            Thread.sleep(1000);
            this.blockingQueue.put("B");
            Thread.sleep(1000);
            this.blockingQueue.put("C");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
