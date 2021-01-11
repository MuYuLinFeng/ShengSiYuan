package com.shengsiyuan._17_reflection._6_execute_property_function

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions

class HelloKotlin112 {
    fun method(message: String) {
        println("执行带String参数的方法 :$message")
    }

    fun method(message: String, price: Double) {
        println("执行带String,Double参数的方法 :$message $price")
    }
}

fun main() {
    val myTestClass = HelloKotlin112::class
    val myObj = myTestClass.createInstance()
    val functions = myTestClass.declaredFunctions
    for (function in functions) {
        // 不能 == 2 普通方法的调用因为对象本身会成为第一个参数
        // 构造方法则不存在这个问题，因为构造方法不依赖于任何对象
        if (function.parameters.size == 3) {
            function.call(myObj, "Ruby", 23.4)

        }
        if (function.parameters.size == 2) {
            function.call(myObj, "Flutter")

        }
    }
}