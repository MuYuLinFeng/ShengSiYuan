package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    asContextElement

    ThreadLocal 相关

 */

val threadLocal = ThreadLocal<String>()


fun main() = runBlocking {
    threadLocal.set("hello")
    println("main,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
    val job = launch(Dispatchers.Default + threadLocal.asContextElement("world")) {
        //这里加入这句话结果会不一样 不会追踪线层本地的修改？？
        threadLocal.set("1111")
        println("launch,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
        println("launch,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
        yield()//让出协程
        println("launch,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
        println("launch,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
    }
    job.join()
    println("main,current thread :${Thread.currentThread()},thread local value ${threadLocal.get()}")
}