package com.shengsiyuan._15_java_use_kotlin;

public class HelloKotlin79Java {
    public static void main(String[] args) {
        //HelloKotlin79Kt helloKotlin79Kt = new HelloKotlin79Kt();
        /*
            HelloKotlin79Kt helloKotlin79Kt = new HelloKotlin79Kt();
            此方法不可行 会报错：
            java: 找不到符号
                符号:   构造器 HelloKotlin79Kt()
                位置: 类 com.shengsiyuan._15_java_use_kotlin.HelloKotlin79Kt

             因为HelloKotlin79Kt是静态类，里面的方法和成员都是静态的 不需要构造函数
             我们无法通过new关键字来创建编译器生成的Kt结尾的类的实例
             因为在生成的字节码中没有不带参数的构造方法
         */
        MyClass myClass = new MyClass();
        HelloKotlin79Kt.setStr("welcome");
        HelloKotlin79Kt.test();
    }
}
