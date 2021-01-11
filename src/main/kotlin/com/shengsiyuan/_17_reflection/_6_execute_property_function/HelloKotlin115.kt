package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaSetter

class HelloKotlin115 {
    var name: String = "Spark"
    var price: Double = 34.5
}

var myTest = "myTest"

fun main() {
    val topProp = ::myTest
    println(topProp.javaField)
    println(topProp.javaGetter)
    println(topProp.javaSetter)
    println("------------")
    val myTestClassName = HelloKotlin115::name
    println(myTestClassName.javaField)
    println(myTestClassName.javaGetter)
    println(myTestClassName.javaSetter)
    println("------------")
    val myTestClassPrice = HelloKotlin115::price
    println(myTestClassPrice.javaField)
    println(myTestClassPrice.javaGetter)
    println(myTestClassPrice.javaSetter)
}