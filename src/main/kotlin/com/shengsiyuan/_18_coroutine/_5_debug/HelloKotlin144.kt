package com.shengsiyuan._18_coroutine._5_debug

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/*
    By print Log
    vm options -Dkotlinx.coroutines.debug
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking<Unit> {
    val a = async {
        log("hello world")
        10
    }

    val b = async {
        log("welcome")
        20
    }
    log("the result is ${a.await() * b.await()}")
}