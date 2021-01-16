package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Flatten Flow 打平

    将嵌套的Flow<Flow<Int>>转换成Flow<Int>
 */

private fun myMethod(i: Int): Flow<String> = flow {
    emit("$i: first")
    delay(500)
    emit("$i: second")
}

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    (1..3)
        .asFlow()
        .onEach {
            delay(100)
        }.flatMapConcat {
            myMethod(it)
        }.collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms")
        }
}