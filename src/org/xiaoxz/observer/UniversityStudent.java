package org.xiaoxz.observer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class UniversityStudent implements Observer {

    private Subject subject;
    private File myFile;

    public UniversityStudent(Subject subject, String myFile) {
        this.subject = subject;
        this.myFile = new File(myFile);
        this.subject.addObserver(this);
    }

    @Override
    public void hearTelephone(String mess) {
        try {
            RandomAccessFile raf = new RandomAccessFile(myFile, "rw");
            raf.seek(raf.length());
            byte[] b = mess.getBytes();
            raf.write(b);
            System.out.println("我是会员一");
            System.out.println("我向文件"+myFile.getName()+"写入如下内容：");
            System.out.println(mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
