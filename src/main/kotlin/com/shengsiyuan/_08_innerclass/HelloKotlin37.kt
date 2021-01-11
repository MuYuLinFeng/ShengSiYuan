package com.shengsiyuan._08_innerclass

//内部类

/*
    内部类和嵌套类的区别
    1.嵌套类：对应于Java的静态内部类（即有static关键字修饰的内部类），
    只要在一个类内部定义了另外一个类，那么这个类就叫做嵌套类，
    相当于Java当中有static关键字修饰的内部类

    2.内部类：对应于Java中的非静态内部类（即没有static关键字修饰的内部类），
    使用inner关键字在一个类的内部所定义的另外一个类就叫做内部类，
    相当于Java当中没有static关键字修饰的内部类

    感觉有点像内部的一个成员变量 所以先创建外部类的实例
    然后用外部类的实例来创建内部类的实例
*/

class OuterClass2 {
    private var str: String = "hello world"

    inner class InnerClass {
        fun innerMethod() = this@OuterClass2.str
    }

    //局部嵌套类 作用域仅限方法内部
    fun getName(): String {
        class LocalNestedClass {
            val name: String = "my test"
        }
        return LocalNestedClass().name
    }
}

fun main() {
    println(OuterClass2().InnerClass().innerMethod())
    println(OuterClass2().getName())
}