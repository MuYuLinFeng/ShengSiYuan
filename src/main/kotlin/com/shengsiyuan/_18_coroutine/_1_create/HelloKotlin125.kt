package com.shengsiyuan._18_coroutine._1_create

import kotlin.concurrent.thread
/*
    repeat里面使用thread和launch有个差别
    thread会乱序列，launch不会乱序列
 */
fun main() {
    repeat(1000) {
        thread {
            Thread.sleep(100)
            println("a $it")
        }
    }
    println("Hello World")
}