package com.h.test.t;

import org.junit.Test;

public class NullTest {

    private Integer age;

    private int num;

    @Test
    public void test(){
        NullTest nullTest = new NullTest();

        System.out.println(nullTest.getAge());
        nullTest.setNum(nullTest.getAge());

        System.out.println(nullTest.getNum());
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
