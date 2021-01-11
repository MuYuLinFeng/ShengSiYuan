package com.shengsiyuan._17_reflection._3_property_reference

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class T(val x: Int)

fun main() {
    println(T::x)
    println(T::x.javaGetter)
    println(T::x.javaField)

    println("-----------")

    println(T(10).javaClass)
    println(T(10).javaClass.kotlin)

    println(String.javaClass)
    println(String.javaClass.kotlin)
}