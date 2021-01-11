package com.shengsiyuan._17_reflection._5_get_property_function

/*
    我们可以引用特定对象的实例方法
    也可以引用特定对象的属性
 */

fun main() {
    val str = "abc"
    val getReference = str::get
    println(getReference(1))

    val myProp = "test"::length
    println(myProp.get())

    val my = "hello world"
    val method = String::length
    println(method.get(my))
    println(String::length.get("hello world"))
}