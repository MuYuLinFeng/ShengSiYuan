package com.shengsiyuan._16_java_use_kotlin;

public class HelloKotlin89Java {
    public static void main(String[] args) {
        MyClass4 myClass4 = new MyClass4();
        myClass4.returnWithNone("hello world");
        //这一句引起运行失败
        myClass4.returnWithNone(null);
    }
}
