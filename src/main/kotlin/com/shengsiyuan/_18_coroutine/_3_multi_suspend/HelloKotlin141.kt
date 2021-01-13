package com.shengsiyuan._18_coroutine._3_multi_suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
    关于父子协程的异常与取消问题
    当协程存在父子关系的话，不管是抛出了异常还是出现了取消，都会沿着层次关系向上传播
    所以不必担心异步时候，某些处理出现异常后，别的处理不知道自己该怎么办
 */

fun main() = runBlocking<Unit> {
    try {
        failureComputation()
    } finally {
        println("Computation failed")
    }
}

private suspend fun failureComputation(): Int = coroutineScope {
    val value1 = async<Int> {
        try {
            delay(9000)
            50
        } finally {
            println("value1 was cancelled")
        }
    }

    val value2 = async<Int> {
        Thread.sleep(2000)
        println("value2 was cancelled")
        throw Exception()
    }
    value1.await() + value2.await()
}