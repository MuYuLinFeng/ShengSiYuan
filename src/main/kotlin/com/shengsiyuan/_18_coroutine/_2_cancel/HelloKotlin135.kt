package com.shengsiyuan._18_coroutine._2_cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/*
    由withTimeout函数调用所抛出的TimeoutCancellationException异常是CancellationException的子类
    当该异常抛出时，我们并未在控制台上看到整个异常堆栈信息，这是因为在取消的协程当中，
    CancellationException被认为是一种协程完成的正常原因而已。
    不过我们在该示例中，是在main函数中使用了withContext函数调用
    既然CancellationException仅仅是个异常而已，所有的资源也都会以通常的方式来关闭，
    那么我们就可以将相关代码放到一个try...catch块中；此外，Kotlin还提供了更友好的函数调用：
    withTimeoutOrNull；从功能角度来看，他非常类似于withTimeout，不过当超时发生时，
    它并不会抛出CancellationException异常，而是会直接返回null
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1900) {
        repeat(10) {
            println("hello $it")
            delay(400)
        }
        "success"
    }
    //result的值是null或者success
    println(result)
}