package com.shengsiyuan._12_exception

import kotlin.IllegalArgumentException

// throw在Kotlin中是个表达式
// 这样我们可以将throw作为Elvis表达式的一部分 Elvis表达式：?:
// throw表达式的类型是一种特殊的类型：Nothing
// Nothing 没有值 标记永远不出触达的代码位置，永远不会返回的函数
fun main() {
    val str: String?
    str = "a"
    val str2 = str ?: throw IllegalArgumentException("值不能为空")
    println(str2)
    println("-------------")

    val str3 = str ?: myMethod("hello")
    println(str3)
    println("-------------")

    var s = null
    println(s is Nothing?)
    println("-------------")

    var s2 = listOf(null)
    println(s2 is List<Nothing?>)
}


fun myMethod(message: String): Nothing {
    throw IllegalArgumentException(message)
}