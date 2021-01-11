package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.companionObject

class HelloKotlin109 {
    companion object MyCompanion{
        fun method() {
            println("hello world")
        }
    }
}

fun main() {
    val myTestClass = HelloKotlin109::class
    val companionObj = myTestClass.companionObject
    println(companionObj)
    HelloKotlin109.method()
}