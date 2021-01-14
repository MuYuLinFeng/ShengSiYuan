package com.shengsiyuan._18_coroutine._6_deepin

import kotlinx.coroutines.*

/*
    协程的声明周期
    MainScope 为Android UI编程准备的
    和Activity绑定
 */

val c = CoroutineScope(Dispatchers.Default)
fun main() = runBlocking {
    val activity = Activity()
    activity.doSomething()
    println("启动协程")
    delay(1300)
    activity.destroy()
    println("销毁协程")
    delay(500)
}

class Activity : CoroutineScope by CoroutineScope(Dispatchers.Default) {
    fun destroy() {
        cancel()
    }

    fun doSomething() {
        repeat(8) {
            launch {
                delay((it + 1) * 300L)
                println("Coroutine $it")
            }
        }
    }
}