package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutine")
    }
    println("Hello ")
    delay(2000)
    println("world")
}