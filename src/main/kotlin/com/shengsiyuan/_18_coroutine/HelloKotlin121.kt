package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val myJob = GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutine")
    }
    println("Hello")
    myJob.join()
    println("World")
}