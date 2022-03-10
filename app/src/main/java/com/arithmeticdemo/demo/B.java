package com.arithmeticdemo.demo;

public class B extends A {


    static {
        System.out.println("B-static");
    }

    public B() {
        System.out.println("B-构造函数");
    }

    public static void printlnStatic() {
        System.out.println("B-static-method");
    }

    @Override
    public void printlnLog() {
//        super.printlnLog();
        System.out.println("B+printlnLog");
    }
}
