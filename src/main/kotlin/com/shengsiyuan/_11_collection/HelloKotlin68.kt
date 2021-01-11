package com.shengsiyuan._11_collection

//Range

fun main() {
    var i = 4
    if (i in 1..5) {//1 5 闭区间
        println(i)
    }
    println("-------------")
    for (a in 1..4) {
        println(a)
    }

    println("-------------")
    for (a in 4 downTo 1) {
        println(a)
    }
    println("-------------")
    for (a in 1..6 step 2) {
        println(a)
    }
    println("-------------")
    for (a in 10 downTo 0 step 3) {
        println(a)
    }
    println("-------左闭右开------")
    for (a in 1 until 6){
        println(a)
    }
    println("-------------")
    for (a in 1 until 6 step 2){
        println(a)
    }
    println("-------------")
    for (a in 0 until 6 step 2){
        println(a)
    }
    println("-------------")
    println("-------------")
}