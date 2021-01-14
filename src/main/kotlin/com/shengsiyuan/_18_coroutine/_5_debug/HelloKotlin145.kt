package com.shengsiyuan._18_coroutine._5_debug

import kotlinx.coroutines.*

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

@ObsoleteCoroutinesApi
fun main() {
    //use 执行完lambda表达时候会自动的释放线程资源
    newSingleThreadContext("Context1").use { ctx1 ->
        newSingleThreadContext("Context2").use { ctx2 ->
            runBlocking(ctx1) {
                log("started in context1")
                launch {
                    log("started launch context1")
                }
                withContext(ctx2) {
                    log("started in context2")
                    launch {
                        log("started launch context2")
                    }
                }
                log("Back to Context1")
            }
        }
    }
}

