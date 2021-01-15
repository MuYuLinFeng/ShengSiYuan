package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    Buffer(缓冲)
    buffer()的作用，对于发射的缓冲减少等待。
    适合流元素本身需要损耗，流元素处理也有等待的时候

    buffer和flowOn的关系：
    实际上flowOn运算符本质上在遇到需要改变CoroutineDispatchers时也会使用同样的缓冲机制，
    只不过下面这个示例并没有改变执行上下文。
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)//模拟了一个较为耗时的操作，该操作时候才开始流元素的发射
        emit(i)
    }
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        myMethod().buffer().collect {
            delay(200)
            println(it)
        }
    }
    println(time)
}