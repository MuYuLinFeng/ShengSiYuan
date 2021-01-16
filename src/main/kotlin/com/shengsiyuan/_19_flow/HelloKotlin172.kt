package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import java.lang.Exception

/*
    Flow的异常处理
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking {
    try {
        myMethod().collect {
            println(it)
            check(it <= 1) {
                //条件反转的情况下进入代码块，并将返回值作为Exception的一部分
                "Collected $it"
            }
        }
    } catch (ex: Exception) {
        println("Caught :$ex")
    }
}