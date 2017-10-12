package org.xiaoxz.fure;

public class Client {

    public Data query(String queryStr) {
        final FutreData futreData = new FutreData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futreData.setRealData(realData);
            }
        }).start();
        return futreData;
    }
}
