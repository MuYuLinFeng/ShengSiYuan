package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties

class HelloKotlin113 {
    var name: String = "Flutter"
    val price: Double = 23.4
}

fun main() {
    val myTestClass = HelloKotlin113::class
    var myObj = myTestClass.createInstance()
    val properties = myTestClass.declaredMemberProperties
    properties.forEach {
        when (it.name) {
            "name" -> {
                val kmp = it as KMutableProperty1<HelloKotlin113, String>
                kmp.set(myObj, "Hadoop")
                println(it.get(myObj))
                println(it.call(myObj))
            }
            "price" -> {
                println(it.get(myObj))
                println(it.call(myObj))
            }
        }
    }
}