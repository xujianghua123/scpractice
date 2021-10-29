package com.h.test.t;

public class ChildClass extends FClass {

    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.a();
        childClass.b();
    }

    public ChildClass(){
        System.out.println("CClass");
    }

    public static void a(){
        System.out.println("CA");
    }

    public void b(){
        System.out.println("CB");
    }

}
