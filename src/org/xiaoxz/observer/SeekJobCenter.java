package org.xiaoxz.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class SeekJobCenter implements Subject {

    private String message;
    private boolean changed;
    private List<Observer> list;

    public SeekJobCenter() {
        this.message = "";
        this.changed = false;
        this.list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        if(this.changed) {
            for(int i=0; i<list.size(); i++) {
                Observer o = list.get(i);
                o.hearTelephone(this.message);
            }
        }
        this.changed = false;

    }

    public void giveMessage(String message) {
        if(message.equals(this.message)) {
            this.changed = false;
        } else {
            this.changed = true;
        }
    }
}
