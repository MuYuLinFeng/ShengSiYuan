package com.shengsiyuan._17_reflection._5_get_property_function

import kotlin.reflect.KClass

fun main() {
    val kotlinLang = "Kotlin"
    val kclass: KClass<out String> = kotlinLang::class
    println(kclass)

    println("--------")

    val kclassDataType: KClass<String> = String::class
    println(kclassDataType)

    println("----------")
    val kclass1: KClass<out String> = "kotlin"::class
    val kclass2: KClass<out String> = "java"::class
    val kclass3: KClass<out String> = "ruby"::class
    println(kclass1)
    println(kclass2)
    println(kclass3)

    println("----------")

    val kclass4 = Class.forName("java.util.Date").kotlin
    println(kclass4)
    println(Class.forName("java.util.Date"))
    println(kclass4 == Class.forName("java.util.Date")) //输出false
    println(kclass4::class)
    println(kclass4::class.java)
    println(kclass4::class.java.kotlin)
}