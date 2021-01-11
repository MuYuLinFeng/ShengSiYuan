package com.shengsiyuan._14_kotlin_use_java

//java某个方法抛出了编译时异常 kotlin中需要在某个地方处理
// 不处理也不会有问题，因为kotlin只有运行时异常
fun main() {
    val myException = HelloKotlin77Java()
    //myException.myMethod()
    println("-----------")

    val javaClass = myException::class.java
    println(javaClass)
    println("-----------")

    val clazz = myException.javaClass
    println(clazz)
    println("-----------")
}