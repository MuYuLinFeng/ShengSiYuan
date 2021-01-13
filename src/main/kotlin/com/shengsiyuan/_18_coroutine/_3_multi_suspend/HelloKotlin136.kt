package com.shengsiyuan._18_coroutine._3_multi_suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    挂起函数的组合
 */
fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        //都是挂起函数 所以会挂起协程并等待
        val value1 = intValue()
        val value2 = intValue2()

        println("$value1 + $value2 = ${value1 + value2}")
    }

    println("total time: $elapsedTime")
}

private suspend fun intValue(): Int {
    delay(2000)
    return 15
}

private suspend fun intValue2(): Int {
    delay(3000)
    return 20
}