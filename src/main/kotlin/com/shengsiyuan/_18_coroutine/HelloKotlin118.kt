package com.shengsiyuan._18_coroutine

import kotlin.concurrent.thread

fun main() {
    val thread = thread {
        Thread.sleep(1000)
        println("Kotlin Thread")
    }
    thread.start()
    println("hello")
    Thread.sleep(2000)
    println("world")
}