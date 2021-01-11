package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.memberProperties

class HelloKotlin107 {
    var name: String = "hello world"
}

fun main() {
    val helloKotlin107 = HelloKotlin107::class
    val testObject = HelloKotlin107()

    val variableToInvoke = helloKotlin107.memberProperties.find { it.name == "name" }
    variableToInvoke?.let {
        println(variableToInvoke.get(testObject))
        println(variableToInvoke.call(testObject))
    }
}