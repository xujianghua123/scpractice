package com.h.test.t;

import org.junit.Test;

public class NullTest {

    private Integer age;

    private int num;

    public NullTest() {
    }

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

    @Test
    public void test1(){
        /*
        String ss = "123";
        String sss = new String("123");
        String ss1 = ss.intern();
        System.out.println(ss == sss);
        System.out.println(ss.equals(sss));
        System.out.println(ss.hashCode());
        System.out.println(sss.hashCode());
        */
        NullTest n1 = new NullTest();
        NullTest n2 = n1;
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));
        System.out.println(n1.hashCode());
        System.out.println(n2.hashCode());
    }
}
