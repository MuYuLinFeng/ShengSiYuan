package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutine")
    }
    println("hello")
    //runBlocking 阻塞线程
    val end = runBlocking {
        delay(2000)
        return@runBlocking "ABC"
    }
    println("world $end")
}