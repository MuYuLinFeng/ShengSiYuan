package com.shengsiyuan._18_coroutine._4_principle

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    Dispatchers.Unconfined
    Unconfined：adj. 自由的；松散的；无拘束的
    suspend函数：挂起函数


    Dispatchers.Unconfined协程分发器会在调用者线程中去启动携程，但仅仅会持续到第一个挂起点；
    当挂起点结束后程序恢复执行时，他会自己协程代码的执行，但这时执行协程的线程是由之前所调用的挂起函数来决定的。
    （这个挂起函数是由哪个线程来执行的，那么后面的代码就会由这个线程来执行）

    Dispatchers.Unconfined协程分发器适用于这样一些协程：
    它既不会消耗CPU时间，同时也不会更新任何共享数据（特定于具体的线程）

    Dispatchers.Unconfined是一种高级的机制，他对于某些特殊情况是有帮助互作用的：
    协程执行的分发是不需要的，或者会产生意料之外的副作用，这是因为协程中的操作必须立刻执行。
    我们在日常行的代码编写中，几乎不会使用Dispatchers.Unconfined这种红协程分发器。
 */

fun main() = runBlocking<Unit> {
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined ,thread : ${Thread.currentThread().name}")
        //这里可以反推delay挂起函数的执行线程是kotlinx.coroutines.DefaultExecutor
        delay(300)
        println("Dispatchers.Unconfined ,thread : ${Thread.currentThread().name}")
    }
    launch {
        println("no param ,thread : ${Thread.currentThread().name}")
        delay(300)
        println("no param ,thread : ${Thread.currentThread().name}")
    }
}