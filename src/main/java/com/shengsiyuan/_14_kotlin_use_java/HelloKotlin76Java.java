package com.shengsiyuan._14_kotlin_use_java;

public class HelloKotlin76Java {
    public void myMethod(String... args) {
        for (String num : args) {
            System.out.println(num);
        }
    }
}
