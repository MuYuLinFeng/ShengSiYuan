package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import java.lang.Exception


/*
    限定数量的中间操作
    take( ... )
 */

fun myNumbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("hello world")//这一句不会打印了
        emit(3)
    } catch (ex: Exception) {
        println(ex)
        //kotlinx.coroutines.flow.internal.AbortFlowException: Flow was aborted, no more elements needed
    } finally {
        println("finally")
    }
}

fun main() = runBlocking {
    myNumbers().take(2).collect {
        println(it)
    }
}