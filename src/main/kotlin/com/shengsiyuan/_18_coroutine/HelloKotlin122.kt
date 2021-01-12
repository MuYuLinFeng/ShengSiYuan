package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
/*
    每一个协程构建器（包括runBlocking）都会向其代码块作用域中添加一个CoroutineScope实例，
    我们可以在该作用域中启动携程，而无需显示将其join到一起，
    这是因为外部协程（在下面示例中就是runBlocking）会等待该作用域中的所有启动的协程全部完成后才会完成。
 */
fun main() = runBlocking {
    launch {
        delay(1000)
        println("Kotlin Coroutine")
    }
    println("Hello")
}