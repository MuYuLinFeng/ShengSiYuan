package com.shengsiyuan._17_reflection._5_get_property_function

import kotlin.reflect.full.memberFunctions

class MyTestClass3(var a: String, val flag: Boolean, var age: Int) {
    val birthday = "1010"
    fun printSomething() {

    }

    fun printNothing() {

    }
}

fun main() {
    val myTestClass3 = MyTestClass3::class
    println(myTestClass3.memberFunctions)
}