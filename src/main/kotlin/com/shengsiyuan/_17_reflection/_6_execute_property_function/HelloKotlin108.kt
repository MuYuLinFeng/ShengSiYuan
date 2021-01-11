package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties

class HelloKotlin108 {
    var name: String = "hello world"
    var authorName: String = "tom"
}

fun main() {
    val myTestClass = HelloKotlin108::class
    val testObject = HelloKotlin108()

    val variableToInvoke = myTestClass.memberProperties.find { it.name == "name" }
    variableToInvoke?.let {
        println(variableToInvoke.call(testObject))
        if (variableToInvoke is KMutableProperty<*>) {
            variableToInvoke.setter.call(testObject, "welcome")
            println(variableToInvoke.call(testObject))
        }
    }
}