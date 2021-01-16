package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
    onCompletion中间操作的一个优势在于他有个可空的Throwable参数，
    可用作确定Flow的收集操作是正常完成还是异常完成的。
 */


private fun myMethod(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking {
    myMethod().onCompletion { cause ->
        if (cause != null) {
            println("Flow Completed Exceptionally")
        }
    }.catch { cause ->
        println("catch entered")
    }.collect { println(it) }
}