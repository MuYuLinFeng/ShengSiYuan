package com.shengsiyuan._02_differjava

fun main() {
    println(convert2Uppercase("hello world"))
    println(convert2Uppercase(25))
}

//Any相当于 java中的object的地位 所有类的超类
fun convert2Uppercase(str: Any): String? {
    if (str is String) {
        return str.toUpperCase()//Smart cast to kotlin.String
    }
    return null
}