package org.xiaoxz.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Plus implements Runnable{

    public static BlockingQueue<Msg> queue = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        try {
            while(true) {
                Msg msg = queue.take();
                msg.setJ(msg.getI() + msg.getJ());
                Mutil.queue.add(msg);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
