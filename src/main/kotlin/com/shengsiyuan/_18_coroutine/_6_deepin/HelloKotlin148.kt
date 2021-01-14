package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    关于父子协程之间的关系
    当一个协程是通过另外一个协程的CoroutineScope来启动的，（CoroutineScope 新协程的作用域范围）
    那么这个协程就会通过CoroutineScope.coroutineContext来继承其外层协程的上下文信息，
    同时，新协程的Job就会成为父协程Job的一个孩子，当父协程被取消时，该父协程的所有孩子都会通过递归的方式一并取消执行。

    特例情况，当我们使用GlobalScope来启动协程时，对于启动的新协程来说，其Job是没有父Job的，
    因此，它就不会绑定到其所启动的那个范围上，故其可以独立执行。（这是一种特殊情况）
 */

fun main() = runBlocking {
    val parentJob = launch {
        val childJob = launch {
            println("child Job start")
            delay(100)
            println("child Job middle")
            delay(1000)
            println("child Job end")//这一行没机会输出了，在500ms的时候父协程cancel掉了
        }
        val globalJob = GlobalScope.launch {
            println("GlobalScope Job start")
            delay(1000)
            println("GlobalScope Job end")
        }
    }
    delay(500)
    parentJob.cancel()
    println("parent End")
    delay(1000)
    println("parent End end")
}
