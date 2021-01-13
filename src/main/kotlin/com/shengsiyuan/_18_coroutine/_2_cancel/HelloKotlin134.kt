package com.shengsiyuan._18_coroutine._2_cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

/*
    我们在使用协程时，如果取消了协程，那么很大一部分原因在于携程的执行时间超过了某个设定值；
    我们可以通过手工引用与携程对应的Job的方式来启动一个单独的协程用于取消这个协程，
    不过Kotlin提供了一个内建的函数来帮助我们又快又好的做到这一点。
 */

fun main() = runBlocking {
    try {
        withTimeout(1900) {
            repeat(10) {
                println("hello $it")
                delay(400)
            }
        }
    } catch (ex: Exception) {
        println("捕获了一个异常 ${ex.localizedMessage}")
    }
}