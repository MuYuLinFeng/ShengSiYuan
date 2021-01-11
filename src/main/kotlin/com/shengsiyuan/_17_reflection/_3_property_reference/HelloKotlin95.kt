package com.shengsiyuan._17_reflection._3_property_reference

/*
    要想访问一个类当中的成员属性，需要使用全限定名称
 */
fun main() {
    val values = listOf("a", "abc", "abcd")
    println(values.map { String::length })//Warning 打印的使length 这个属性对象的信息
    //[val kotlin.String.length: kotlin.Int,
    // val kotlin.String.length: kotlin.Int,
    // val kotlin.String.length: kotlin.Int]
    println(values.map(String::length))

    println("------------")
    //反射方式
    val x = MyClass::x
    println(x.get(MyClass(10)))

    //非反射的常规使用
    val myClass = MyClass(100)
    println(myClass.x)
}

class MyClass(val x: Int)