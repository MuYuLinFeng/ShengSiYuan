package com.shengsiyuan._18_coroutine._2_cancel

import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

fun main() = runBlocking {
    val job = GlobalScope.launch {
        repeat(20) { i ->
            println("hello $i")
            //delay操作会做取消状态的检查 此处可以应证HelloKotlin131.kt
            delay(500)
        }
    }
    delay(1100)
    println("hello world")
    //cancel和join不可分离，因为cancel不是立刻会执行，
    //所以必须join，等待cancel确实执行后并返回来
    job.cancel(CancellationException("just a try"))
    job.join()
    //上面两句 下面一句二选一
    //job.cancelAndJoin()

    println("welcome")
}