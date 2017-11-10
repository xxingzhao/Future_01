package org.xiaoxz.observer;


/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public interface Subject {

    void addObserver(Observer o);
    void deleteObserver(Observer o);
    void notifyObservers();
}
