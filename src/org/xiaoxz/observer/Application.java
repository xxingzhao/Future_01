package org.xiaoxz.observer;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class Application {
    
    
    public static void main(String[] args){
        SeekJobCenter jobCenter = new SeekJobCenter();
        UniversityStudent student = new UniversityStudent(jobCenter, "D:\\a.txt");
        jobCenter.giveMessage("XX需要是个采购员");
        jobCenter.notifyObservers();
    }
}
