package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

/*
    Flow的完成

    Kotlin提供了两种方式来实现Flow的完成：
    1.命令式
    2.声明式
 */

private fun myMethod(): Flow<Int> = (1..10).asFlow()

fun main() = runBlocking {
    try {
        myMethod().collect {
            println(it)
        }
    } finally {//命令式
        println("finally")
    }
}