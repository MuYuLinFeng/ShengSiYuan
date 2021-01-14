package com.shengsiyuan._19_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    目的：不阻塞主线程，并且计算结果完成一次就返回一次

    如果返回List<String>结果类型，那么就表示只能一次性返回所有值，想要能够表示可以异步计算的流式的值，
    我们就可以使用Flow<String>类型，它非常类似于Sequence<String>类型，但其值是异步计算的。

    1.Flow构建器是通过flow来实现的
    2.位于flow{}构建器中的代码是可以挂起的。
    3.myMethod()方法无需在使用suspend标识符，值是通过emit函数来发射出来的
    4.Flow里面的值是通过collect方法来收集的。
 */

private fun myMethod(): Flow<Int> = flow {
    for (i in 1..4) {
        delay(100)
        //用Thread.sleep的效果和delay完全不同
        //Thread.sleep(100)
        println("myMethod   ${Thread.currentThread().name}")
        emit(i)
    }
}

fun main() = runBlocking {
    launch {
        for (i in 1..4) {
            println("launch     ${Thread.currentThread().name}    $i")
            delay(200)
        }
    }
    //delay(100)
    myMethod().collect {
        println("collect    ${Thread.currentThread().name}    $it")
    }
}