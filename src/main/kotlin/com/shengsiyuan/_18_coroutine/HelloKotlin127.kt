package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    被suspend修饰的函数叫做挂起函数
    挂起函数在Kotlin中叫做 (suspending function)

    挂起函数可以像普通函数一样用在协程当中，不过它拥有自己的一些特性：可以使用其他的挂起函数。
    重点：挂起函数只能用在协程或者另外一个挂起函数当中。

    大概意思就是挂起函数只能和挂起函数或者协程玩儿
    普通函数不能调用挂起函数，只能由携程作为起点，然后各种挂起函数和普通函数自由飞翔
 */

fun main() = runBlocking {
    //注意：这里使用的launch而不是GlobalScope.launch，两者的区别会引起结果不同
    //区别见HelloKotlin123.kt
    launch {
        world()
    }
    println("Welcome")
}

suspend fun hello() {
    delay(4000)
    println("Hello World")
}

suspend fun world() {
    hello()
}