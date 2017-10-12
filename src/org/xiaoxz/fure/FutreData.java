package org.xiaoxz.fure;

public class FutreData implements Data{
    private RealData realData;
    private boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        System.out.println("setData");
        if(isReady)
            return;
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        if(!isReady) {
            try {
                System.out.println("getResult");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();
    }
}
