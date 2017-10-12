package org.xiaoxz.fure;

public class FutreMain {

    public static void main(String[] args){
        Client client = new Client();
        Data data = client.query("name");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Before");
        System.out.println("数据 " +data.getResult());
        System.out.println("After");
    }
}
