package org.xiaoxz.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    private BlockingQueue<PcData> queue;
    private static AtomicInteger count = new AtomicInteger(0);
    private static int counts = 0;
    private volatile static boolean isRunning = true;
    private final static int SLEEPTiME = 1000;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        PcData pcData = null;
        Random random = new Random();
        System.out.println("Start Produce Thread is " + Thread.currentThread().getId());
        try {
            while(isRunning) {
                Thread.sleep(random.nextInt(SLEEPTiME));
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
        this.isRunning = false;
    }

}
