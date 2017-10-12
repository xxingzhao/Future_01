package org.xiaoxz.fure;

public class RealData implements Data {

   final String result;
    public RealData(String param) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<10; i++) {
            sb.append(param);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.result = sb.toString();

    }

    @Override
    public String getResult() {
        return result;
    }
   
   @Override
   public String toString() {
     String hello = "Hello World";
     hello.split("");
     System.out.println(hello);
      System.out.println(hello);
     String[] arr = hello.split("");
     for (String s:arr) {
         System.out.println(s);
     }
     return "result:" + result;
   }
}
