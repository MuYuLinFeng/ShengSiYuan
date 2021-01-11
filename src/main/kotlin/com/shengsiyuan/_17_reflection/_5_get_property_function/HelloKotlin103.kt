package com.shengsiyuan._17_reflection._5_get_property_function

import kotlin.reflect.full.memberProperties

class MyTestClass2(var a: String, val flag: Boolean, var age: Int) {
    val birthday = "1010"
}

fun main() {
    val myTestClass2 = MyTestClass2::class
    println(myTestClass2.memberProperties)
}