package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

/*
    Flow完成的声明式方法
    对于声明式来说，Flow提供了一个名为onCompletion中间操作，
    改操作会在flow完成收集后得到调用（其他的所有中间操作都会比终止操作先执行）

    onCompletion是在终止操作之后执行的
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking {
    myMethod().onCompletion {
        println("onCompletion")
    }.collect {
        println(it)
    }
}