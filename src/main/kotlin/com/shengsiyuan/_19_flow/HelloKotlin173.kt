package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow的异常处理
 */

private fun myMethod(): Flow<String> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}.map { value ->
    check(value <= 1) { "Crash on $value" }
    "string $value"
}

fun main() = runBlocking {
    try {
        myMethod().collect { println(it) }
    } catch (ex: Throwable) {
        println("Caught :$ex")
    }
}