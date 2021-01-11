package com.shengsiyuan._17_reflection._3_property_reference

/*
    扩展属性
 */

val String.firstChar: Char
    get() = this[2]

fun main() {
    val str = "xyz"
    println(str.firstChar)
    println(String::firstChar.get("12345"))
}