package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //launch函数不会阻塞线程执行，而是在后台新创建一个协程。
    GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutines")
    }
    println("hello")
    /*
        如果这里睡眠500毫秒的话，协程块儿里面的打印将不会执行。
        因为线程在500毫秒之后就执行并结束了，这时候协程还没有来得及执行。
     */
    Thread.sleep(2000)
    println("world")
}