package org.xiaoxz.block;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockqueueExample {

    public static void main(String[] args){
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

        new Thread(new Producer(queue)).start();
        new Thread(new Cunsumer(queue)).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String body = URLEncoder.encode("车险商品", "UTF-8");
            System.out.println(body);
            body = null;
            String content = URLDecoder.decode(body, "UTF-8");
            System.out.println(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
