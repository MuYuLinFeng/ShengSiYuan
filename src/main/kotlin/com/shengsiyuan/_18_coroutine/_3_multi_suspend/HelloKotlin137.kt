package com.shengsiyuan._18_coroutine._3_multi_suspend

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
    使用async和await实现并发
    从概念上来说，async就像是launch一样，它会开启一个单独的协程，
    这个协程是个轻量级线程，可以与其他协程并发工作。

    区别在于launch会返回一个Job，但是Job并不会持有任何结果值，
    而async会返回一个Deferred，这是一个轻量级的非阻塞的future，
    它代表一个promise，可以再稍后提供一个结果值。

    可以通过再一个deferred值上调用await方法来获取最终的结果值，
    Deferred也是一个Job，因此可以在需要时对其进行取消。
 */

fun main() = runBlocking {
    val elapsedTime = measureTimeMillis {
        val value1 = async { intValue() }
        val value2 = async { intValue2() }
        val result1 = value1.await()
        val result2 = value2.await()
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