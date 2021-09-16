package com.h.test.t;

import org.junit.Test;

public class NTest {

    private Integer age;

    private int num;

    @Test
    public void test(){
        NTest nTest = new NTest();

        System.out.println(nTest.getAge());
        nTest.setNum(nTest.getAge());

        System.out.println(nTest.getNum());
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
