package com.shengsiyuan._17_reflection._1_KClass

fun main() {
    val cJava = String::class.java
    println(cJava)
    println("---  this is a string  --")
    val cStr = "this is a string"
    println(cStr.javaClass)
    println(cStr::class)
    println(cStr::class.java)
    println("--------------")
    val cClass = String::javaClass
    println(cClass)
    println("--------------")
    val c = String::class //KClass
    println(c)
}