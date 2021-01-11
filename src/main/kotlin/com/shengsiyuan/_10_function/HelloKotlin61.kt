package com.shengsiyuan._10_function

/*
    匿名函数


 */
fun main() {

    val strings = arrayOf("hello", "world", "bye")
    strings.filter { it.length > 3 }.forEach { println(it) }

    strings.filter(fun(item): Boolean = item.length > 3).forEach { println(it) }
    strings.filter(fun(item: String): Boolean = item.length > 3).forEach { println(it) }
}