package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    + 运算符的重载
 */

fun main() = runBlocking(CoroutineName("myCoroutine")) {
    val value = launch(Dispatchers.Default + CoroutineName("launch")) {
        println("thread :${Thread.currentThread().name}")
    }
    println("thread :${Thread.currentThread().name}")
}