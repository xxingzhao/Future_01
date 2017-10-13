package org.xiaoxz.concurrent;

public class Main {

    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Mutil()).start();
        new Thread(new Div()).start();

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
