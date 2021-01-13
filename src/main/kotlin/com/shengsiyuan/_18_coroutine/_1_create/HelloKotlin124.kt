package com.shengsiyuan._18_coroutine._1_create

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    协程是轻量级的
 */

fun main() = runBlocking {
    repeat(100000) {
        launch {
            delay(100)
            println("abc $it")
        }
    }
    println("Hello World")
}