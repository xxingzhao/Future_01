package org.xiaoxz.sort;

import java.lang.reflect.ParameterizedType;

/**
 * @Author : xiaoxz
 * @Date: Created in 2017/10/16
 * @Modified by :
 **/
public class Student<T> extends Person implements BaseDao {

    private float score;
    private int grade;
    private Class<T> clazz;

    public Student() {
        this.clazz = (Class<T>) ((ParameterizedType)Student.class.getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void delete(int id) {

    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
