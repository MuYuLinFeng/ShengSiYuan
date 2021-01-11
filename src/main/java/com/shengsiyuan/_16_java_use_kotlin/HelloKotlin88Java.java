package com.shengsiyuan._16_java_use_kotlin;

import java.io.FileNotFoundException;

public class HelloKotlin88Java {
    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        try {
            myClass3.method();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
