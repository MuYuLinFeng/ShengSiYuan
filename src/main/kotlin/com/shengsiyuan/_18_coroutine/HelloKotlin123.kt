package com.shengsiyuan._18_coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    除去不同的协程构建器所提供的协程作用域之外，我们还可以通过coroutineScope builder来声明自己的作用域。
    该构建器会创建一个协程作用域，并且会等待所有启动的子协程全部完成后自身才会完成。

    runBlocking与coroutineScope之间的主要差别在于，
    后者(coroutineScope builder)在等待所有子协程完成其任务是并不会阻塞当前的线程。
    而runBlocking会阻塞主线程。

    runBlocking 并非挂起函数；也就是说，调用它的线程会一直位于该函数之中，直到携程执行完毕为止。
    coroutineScope 是挂起函数；也就是说如果其中的携程挂起，那么coroutineScope函数也会挂起，
        这样创建coroutineScope的外层函数就可以继续在同一个线程中执行了。
        该线程会「逃离」coroutineScope之外，并且可以做其他一些事情。
 */
fun main() = runBlocking {
    launch {
        delay(1000)
        println("my job1")
    }
    println("person")
    /*
        老师：coroutineScope 等待所有子协程结束后自身才会结束
     */

    /*
        弹幕：welcome最后输出是因为 coroutineScope 方法是 suspend的
            和delay一样都是会阻塞流程继续，但是不会阻塞线程。
     */

    /*
        我们客观看到的是代码的流程是否向下执行
        在挂起函数 coroutineScope执行期间，
        线程跑去执行coroutineScope之前的事件了
        等待coroutineScope执行结束回来再继续执行下面的流程。
        而不是像runBlocking客观的阻塞了线程使得代码流程停止。
     */
    coroutineScope {
        launch {
            delay(20000)
            println("my job2")
        }
        delay(5000)
        println("hello world")
    }
    println("welcome")
}