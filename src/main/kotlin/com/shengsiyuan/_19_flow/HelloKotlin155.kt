package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
    协程完成类似前两个例子的效果：
    1.不会阻塞主线程
    2.将结果全部或取到了再同一返回
 */

private suspend fun myMethod(): List<String> {
    delay(100)
    return listOf("hello", "world", "hello world")
}

fun main() = runBlocking {
    myMethod().forEach { println(it) }
}