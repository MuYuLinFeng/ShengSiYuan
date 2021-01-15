package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*
    Flow的中间运算符
    Flow的中间运算符的思想与Java Stream完全一样

    Flow与Sequence之间在运算符上的重要差别在于：对于Flow来说，这些中间运算符内的代码块是可以调用挂起函数的。
 */
private suspend fun myExecution(input: Int): String {
    delay(1000)
    return "output $input"
}

fun main() = runBlocking {
    val jon = (1..10).asFlow()
        .filter { it > 5 }
        .map { input ->
            myExecution(input)
        }.collect {
            println(it)
        }
}