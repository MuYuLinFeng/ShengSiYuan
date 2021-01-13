package com.shengsiyuan._18_coroutine._3_multi_suspend

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    sync参数CoroutineStart.LAZY模式的执行契机
        Deferred.await方法调用或者Job.start方法调用
        只调用Deferred.await是串行执行
        先调用Job.start再调用Deferred.await是并行执行
 */
fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async(start = CoroutineStart.LAZY) { intValue() }
        val value2 = async(start = CoroutineStart.LAZY) { intValue2() }

        println("hello world")
        Thread.sleep(6000)
        //start 不是挂起方法不阻塞协程，所以两个async块同时执行开始
        value1.start()
        value2.start()
        println("welcome 0")
        //await在start第二秒的时候返回结果
        val result1 = value1.await()//await是挂起方法，会阻塞协程
        println("welcome 1")
        //await在start第三秒的时候返回结果，同时也是上一个打印之后的一秒
        val result2 = value2.await()
        println("welcome 2")
        println("$result1 + $result2 = ${result1 + result2}")
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