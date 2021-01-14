package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/*
    Flow当我们调用myMethod方法之后其实是立刻返回了Flow对象
    但是需要调用终止操作符才会flow对象才会执行一次
 */

private fun myMethod(): Flow<Int> = flow {
    println("myMethod execute")
    for (i in 1..3) {
        kotlinx.coroutines.delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    println("hello")
    val flow = myMethod()
    flow.collect {
        //终止操作符之一
        println(it)
    }
    println("world")
    flow.collect {
        println(it)
    }
}