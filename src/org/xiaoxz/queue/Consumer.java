package org.xiaoxz.queue;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<PcData> queue;
    private volatile boolean isRunning = true;
    private static int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PcData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PcData pcData = null;
        Random random = new Random();
        System.out.println("Start consumer id " + Thread.currentThread().getId());
        try {
            while(isRunning) {
                pcData = queue.take();
                if(pcData != null) {
                    int re = pcData.getValue() * pcData.getValue();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", pcData.getValue(), pcData.getValue(), re));
                    Thread.sleep(random.nextInt(SLEEPTIME));
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
