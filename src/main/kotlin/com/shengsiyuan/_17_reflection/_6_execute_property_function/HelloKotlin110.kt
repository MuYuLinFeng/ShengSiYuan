package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

class HelloKotlin110(value: Int = 0) {
    fun printSomething() {
        println("something")
    }

    fun printNothing() {
        println("nothing")
    }
}

fun main() {
    val myTestClass = HelloKotlin110::class
    val myObj = myTestClass.createInstance()
    val funSomething = myTestClass.functions.find { it.name == "printSomething" }
    funSomething?.let {
        funSomething.call(myObj)
    }
    val funNothing = myTestClass.functions.find { it.name == "printNothing" }
    funNothing?.let {
        funNothing.call(myObj)
    }
}