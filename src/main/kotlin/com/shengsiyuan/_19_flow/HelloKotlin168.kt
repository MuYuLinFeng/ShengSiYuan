package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer(缓冲)
    无buffer
 */
private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)//模拟了一个较为耗时的操作，该操作时候才开始流元素的发射
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod().collect {
            delay(200)
            println(it)
        }
    }
    println(time)
}