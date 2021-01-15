package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
    transform 流的转换
 */

private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output $input"
}

fun main() = runBlocking {
    (1..10).asFlow().transform { input ->
        //这里可以做任何操作和逻辑，更为通用的转换操作，比map filter更强大的方法
        emit("my input :$input")
        emit(myExecution(input))
        emit("hello world")
    }.collect { println(it) }
}