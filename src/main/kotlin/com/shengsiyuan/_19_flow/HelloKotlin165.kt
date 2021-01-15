package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Flow Context(Flow上下文)
    Flow的收集动作总是发生在调用协程的上下文当中。和定义的位置上下文没有任何关系，
    这个特性叫Context Preservation（上下文保留）
 */

private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

private fun myMethod(): Flow<Int> = flow {
    log("myMethod started")
    for (i in 1..4) {
        emit(i)
    }
}

fun main() = runBlocking {
    myMethod().collect {
        log("collect $it")
    }
    //流会卡主线程，流执行完了才会执行这一行打印
    println("runBlocking")
}