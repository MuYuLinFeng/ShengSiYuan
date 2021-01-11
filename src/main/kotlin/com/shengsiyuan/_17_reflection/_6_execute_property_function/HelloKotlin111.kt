package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.createInstance

class HelloKotlin111(var name: String) {
    var price = 0.0
    var has = false

    constructor() : this("unknown") {
        this.price = 0.0
    }

    constructor(name: String, price: Double) : this(name) {
        this.price = price
    }
}

fun main() {
    val myTestClass = HelloKotlin111::class
    val instance = myTestClass.createInstance() //类似于Java中的newInstance 都是调用无参构造方法来创建实例
    println(instance.name)
    println(instance.price)
    println("-----------")
    val cons = myTestClass.constructors
    cons.forEach {
        if (it.parameters.size == 2) {
            val instance2 = it.call("Apple", 20.0)
            println(instance2.name)
            println(instance2.price)
        }
    }
}