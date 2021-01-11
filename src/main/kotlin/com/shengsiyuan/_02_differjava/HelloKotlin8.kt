package com.shengsiyuan._02_differjava

fun main() {
    var a = 5
    var b = 10
    if (a in 2..b) {
        println("in the range")
    }

    println("---------------------------")
    if (a !in 2..b) {
        println("out of the range")
    }

    println("---------------------------")
    for (i in 2..10) {//闭区间
        println(i)
    }

    println("---------------------------")
    for (i in 2.rangeTo(10)) {//闭区间
        println(i)
    }

    println("---------------------------")
    for (i in 2..10 step 3) {//闭区间
        println(i)
    }

    println("---------------------------")
    for (i in 10 downTo 2 step 3) {//闭区间
        println(i)
    }
}