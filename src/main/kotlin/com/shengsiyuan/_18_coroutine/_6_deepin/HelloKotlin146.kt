package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.job
import kotlinx.coroutines.runBlocking

/*
    Job的使用方式以及在Context中的具体应用

    协程的Job是归属于其上下文（CoroutineContext）的一部分，
    Kotlin为我们提供了一种简洁的手段来通过协程上下文获取到协程自身的Job对象

    我们可以通过coroutineContext[Job]表达式来访问上下文中的Job对象
 */

fun main() = runBlocking {
    //coroutineContext代表当前协程的上下文
    val job: Job? = coroutineContext[Job]
    println(job)//BlockingCoroutine{Active}@4ccabbaa

    val job2 = coroutineContext.job
    println(job2)

    println(coroutineContext.isActive)
    println(job?.isActive)
}