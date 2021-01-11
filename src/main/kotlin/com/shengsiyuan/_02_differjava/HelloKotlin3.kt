package com.shengsiyuan._02_differjava

import com.shengsiyuan._02_differjava2.multiply as myMultiply

fun main() {
    myPrint(2, 7)
    println(sum(1, 2))

    val a: Int = 1 //常量
    val b = 2
    var c: Int//变量
    c = 3
    c = 4
    println(a)
    println(b)
    println(c)
    var x = 10
    var y: Byte = 20
    x = y.toInt()//kotlin中类型必须显示转换
    println(x)
    println(myMultiply(2, 5))//跨包引用 和 别名使用


    val n = intArrayOf(1, 2, 3)
    n[0] = 4
    n.forEach { println(it) }
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun myPrint(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}