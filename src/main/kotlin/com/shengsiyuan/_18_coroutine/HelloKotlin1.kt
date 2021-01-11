package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutines")
    }
    println("hello")
    Thread.sleep(2000)
    println("world")
}