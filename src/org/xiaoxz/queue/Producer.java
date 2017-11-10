package org.xiaoxz.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Producer implements Runnable{

    private BlockingQueue<PcData> queue;
    private static AtomicInteger count = new AtomicInteger(0);
    private static int counts = 0;
    private volatile static boolean IS_RUNNING = true;
    private final static int SLEEP_TiME = 1000;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        PcData pcData = null;
        Random random = new Random();
        System.out.println("Start Produce Thread is " + Thread.currentThread().getId());
        try {
            while(IS_RUNNING) {
                Thread.sleep(random.nextInt(SLEEP_TiME));
                pcData = new PcData(++counts);
                if(!queue.offer(pcData, 20L, TimeUnit.SECONDS)) {
                    System.out.println("Fail to put PcData " + pcData);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        IS_RUNNING = false;
    }

}
