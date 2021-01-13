package com.shengsiyuan._18_coroutine._3_multi_suspend

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    异步风格的函数
    GlobalScope.async 将挂起函数转换成了类似普通函数
 */

fun main() {
    val elapsedTime = measureTimeMillis {
        val value1 = intValue1Async()
        val value2 = intValue2Async()
        //这种异步风格的函数官方不建议使用，
        //因为如果在当前这里发生了异常，程序终止后，不会执行后面的代码，
        //协程可能会没有机会被停止 解决方案见下一个文件
        runBlocking {
            println("the answer is ${value1.await() + value2.await()}")
        }
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

fun intValue1Async() = GlobalScope.async {
    intValue()
}

fun intValue2Async() = GlobalScope.async {
    intValue2()
}