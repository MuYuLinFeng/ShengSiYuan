package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.functions

class HelloKotlin106 {
    fun printSomething(name: String, yes: Boolean) {
        println("something $name $yes")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    println("------- 传统方式 ------")
    val testClass = HelloKotlin106()
    println(testClass.printNothing())
    println(testClass.printSomething("hello world", false))

    println("------- 反射方式 ------")
    val helloKotlin106 = HelloKotlin106::class
    var functionToInvoke = helloKotlin106.functions.find { it.name == "printNothing" }
    functionToInvoke?.call(testClass)

    functionToInvoke = helloKotlin106.functions.find { it.name == "printSomething" }
    functionToInvoke?.let {
        functionToInvoke.call(testClass, "big pig", false)
    }
}