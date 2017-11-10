package org.xiaoxz.concurrent;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(3, 10, 120L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        service.execute(new Plus());
        service.execute(new Mutil());
        service.execute(new Div());

      /*  new Thread(new Plus()).start();
        new Thread(new Mutil()).start();
        new Thread(new Div()).start();*/

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                Msg msg = new Msg();
                msg.setI(i);
                msg.setJ(j);
                msg.setOrgStr("("+i+"+"+j+")*"+i+"/2");
                Plus.queue.add(msg);
            }
        }
    }
}
