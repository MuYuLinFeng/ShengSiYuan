package com.shengsiyuan._18_coroutine._2_cancel

import kotlinx.coroutines.*

/*
    使用finally来关闭资源
    join与cancelAndJoin都会等待所有清理动作完成后才会继续往下执行
 */

fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) { i ->
                println("job I am sleeping $i")
                delay(500)
            }
        } finally {
            println("执行了finally块")
        }
    }
    delay(1300)
    println("hello world")
    myJob.cancelAndJoin()
    println("welcome")
}