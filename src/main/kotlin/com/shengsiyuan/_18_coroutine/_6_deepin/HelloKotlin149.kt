package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    指定协程的名字
    CoroutineName上下文元素可以让我们对协程进行命名，以便能够输出可读性比较好的日志信息
 */


private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

fun main() = runBlocking(CoroutineName("runBlocking")) {
    log("hello")
    val value1 = async(CoroutineName("async1")) {
        delay(800)
        log("async1")
        30
    }
    val value2 = async(CoroutineName("async2")) {
        delay(800)
        log("async2")
        20
    }
    log("Result is ${value1.await() * value2.await()}")
}