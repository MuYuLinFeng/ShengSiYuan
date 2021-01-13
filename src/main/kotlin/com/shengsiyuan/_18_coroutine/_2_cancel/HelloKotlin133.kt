package com.shengsiyuan._18_coroutine._2_cancel

import kotlinx.coroutines.*

/*
    当我们在协程中的finally块中使用了挂起函数时，会导致出现CancellationException异常，
    原因在于运行着改代码块的协程已经被取消了，通常情况下，这并不会产生什么问题，
    因为大多数关闭操作（比如说取消一个job，关闭网络连接等）通常都是非阻塞的，并不需要使用挂起函数；
    然而，在极少数情况下，当我们在一个取消协程中进行挂起操作时，
    我们可以将相应的代码放置到withContext（NonCancellable）当中。
    在这种结构中，我们实际上使用了withContext函数与NonCancellable上下文

 */
fun main() = runBlocking {
    val myJob = launch {
        try {
            repeat(100) { i ->
                println("job I am sleeping $i")
                delay(500)
            }
        } finally {
            withContext(NonCancellable){
                println("执行了withContext块")
                try {
                    delay(1000)
                    println("在withContext delay后执行的代码片段\n")
                } catch (ex: Exception) {
                    println("withContext捕获了一个异常 ${ex.localizedMessage}")
                }
            }
            //进入这个代码块后，协程已经结束返回到了上级协程
            println("执行了finally块")
            try {
                delay(1000)
                println("在delay后执行的代码片段")
            } catch (ex: Exception) {
                println("捕获了一个异常 ${ex.localizedMessage}")
            }
        }
    }
    delay(1300)
    println("hello world")
    myJob.cancelAndJoin()
    println("welcome")
}