package com.shengsiyuan._19_flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

/*
    flowOn
    借助于flowOn，可以让Flow在发射元素时所处的上下文与收集（终止操作）时所处的上下文是不同的。
    值得注意的是：flowOn操作符改变了而Flow本身默认的顺序性。
    现在收集操作发生在一个协程中，发射操作发生在另一个协程当中，变成了异步操作。
    flowOn本质上会改变上下文中的 Coroutine Dispatcher 并且为上游的Flow创建另外一个协程。
 */
private fun log(logMessage: String) = println("[${Thread.currentThread().name}] $logMessage")

private fun myMethod(): Flow<Int> = flow {
    log("started")
    for (i in 1..4) {
        log("withContext")
        Thread.sleep(100)
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking {
    myMethod().collect {
        log("collect $it")
    }
    log("runBlocking")
}