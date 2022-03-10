package com.arithmeticdemo.demo;

public class A {

    static {
        System.out.println("A-static");
    }

    public A(){
        System.out.println("A-构造函数");
    }

    public static void printlnStatic() {
        System.out.println("A-static-method");
    }

    public void printlnLog() {
        System.out.println("A...println");
    }


}
