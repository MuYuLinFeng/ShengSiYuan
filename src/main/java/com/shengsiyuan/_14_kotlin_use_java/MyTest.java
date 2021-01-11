package com.shengsiyuan._14_kotlin_use_java;

public class MyTest {
    public static void main(String[] args) {
        //在java中 父类型的变量可以指向子类型对象
        Object[] objects = new String[4];
        objects[0] = "sss";
        objects[1] = "bbbb";
        //Java只关心声明类型，所以任意子类型可以赋给父类型
        //这两句引起运行失败
        objects[2] = 1;
        objects[3] = 2;
    }
}
