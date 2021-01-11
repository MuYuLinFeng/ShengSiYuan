package com.shengsiyuan._17_reflection._5_get_property_function

import kotlin.reflect.full.primaryConstructor

class MyTestClass4(value: Int) {
    constructor(amount: Int, color: String) : this(amount) {

    }

    constructor(amount: Int, full: Boolean) : this(amount) {

    }
}

fun main() {
    val myTestClass4 = MyTestClass4::class
    println(myTestClass4.primaryConstructor)
    println(myTestClass4.constructors)
}