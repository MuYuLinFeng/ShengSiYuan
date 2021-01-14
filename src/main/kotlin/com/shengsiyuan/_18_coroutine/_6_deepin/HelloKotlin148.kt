package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    对于父子协程来说，父协程总是会会等待其所有子协程的完成，对于父协程来说，
    它不必显示的追踪由他所启动的所有子协程，同时也不必调用Job.join方法来的鞥带子协程的完成。
 */

fun main() = runBlocking {
    val job = launch {
        repeat(5) { i ->
            launch {
                delay((i + 1) * 100L)
                println("Coroutine $i 执行完毕")
            }
        }
        println("hello")
    }
    job.join()//这是一个挂起函数
    println("world")
}