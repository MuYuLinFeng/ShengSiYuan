package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.createInstance

class HelloKotlin114 {
    var name: String = "Spark"
    val price: Double = 34.5
}

var test = "test"
fun main() {
    val topProp = ::test
    topProp.set("修改后的数据")
    println(topProp)
    println(topProp.get())
    println(test)
    println("-------------")
    val myTestClass = HelloKotlin114::class
    val myObj = myTestClass.createInstance()
    val name = HelloKotlin114::name
    name.set(myObj, "Ruby")
    println(name.get(myObj))
    println(name.call(myObj))
    println("-------------")
    val prop = HelloKotlin114::price
    println(prop.get(myObj))
}