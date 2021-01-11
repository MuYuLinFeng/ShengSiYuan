package com.shengsiyuan._16_java_use_kotlin

/*
    平台生成的getter setter和自己显示定义的方法重名
 */
class MyClass {
    val a: Int
        @JvmName("getAValueJava")
        get() = 20

    fun getA() = 30
}

fun main() {
    val myClass = MyClass()
    println(myClass.getA())
    println(myClass.a)
}