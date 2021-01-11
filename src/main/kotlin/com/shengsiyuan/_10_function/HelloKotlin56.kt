package com.shengsiyuan._10_function

/*
    内联函数（inline function）

    内联函数的函数体会再被调用的地方拷贝使用
*/

inline fun myCalculate(a: Int, b: Int) = a + b

fun main() {
    println(myCalculate(1, 2))
}