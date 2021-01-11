package com.shengsiyuan._10_function

/*
    闭包

    lambda表达式或者匿名函数访问外部的变量
*/
fun main() {
    var sum = ""
    val strings = arrayOf("hello", "world", "bye")
    strings.filter { it.length > 3 }.forEach {
        sum += it
    }
    println(sum)
}