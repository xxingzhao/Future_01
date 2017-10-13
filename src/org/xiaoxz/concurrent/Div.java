package org.xiaoxz.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Div implements Runnable {
    public static BlockingQueue<Msg> queue = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        try {
            while(true) {
                Msg msg = queue.take();
                msg.setJ(msg.getI()/2);
                System.out.println(msg.getOrgStr() +"=" + msg.getJ());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
