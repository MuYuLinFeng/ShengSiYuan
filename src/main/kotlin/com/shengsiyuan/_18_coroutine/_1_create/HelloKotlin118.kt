package com.shengsiyuan._18_coroutine._1_create

import kotlin.concurrent.thread

fun main() {
   thread {
        Thread.sleep(1000)
        println("Kotlin Thread")
    }
    println("hello")
    Thread.sleep(2000)
    println("world")
}