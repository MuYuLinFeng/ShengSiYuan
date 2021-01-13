package com.shengsiyuan._18_coroutine._4_principle

import kotlinx.coroutines.*
import java.util.concurrent.Executors

/*
    协程和线程之间的关系
    协程上下文与分发器(CoroutineContext与Dispatcher)
    上下文： 运行的环境
    分发器：协程代码到底由谁来执行（归根结底是线程）

    协程总是会在某个上下文中执行，这个上下文实际上是由 CoroutineContext 类型的一个实例来表示的，
    该实例是由Kotlin标准库来定义的。

    协程上下文本质上是各种元素所构成的一个集合，其中主要元素包括携程的Job以及分发器。
    所谓的分发器，其主要功能就是确定由哪个线程来执行我们所指定的协程代码。

    协程上下文包含了一个协程分发器(CoroutineDispatcher)，协程分发器确定了到底由哪个线程或者线程池来执行我们所指定的协程。
    协程分发器可以将协程的执行限制到一个具体指定的线程，也可以将协程的执行分发到一个线程池中，
    由线程池中的某个线程来执行我们指定的协程，还可以不加任何限制的去执行我们所指定的协程代码（这时候谁执行协程代码快是不确定的
    他需要根据程序的实际执行情况才能明确，这种方式的协程分发器在开发中使用时较少的，只在某些极为特殊的情况下才会使用）。

    所有的协程构建器（Coroutine builder）如launch和async都会接收一个可选的CoroutineContext参数，
    该参数可用于显示指定新协程所运行的分发器以及其他上下文元素。

    程序分析：
    1.当通过launch来启动协程并且不指定协程分发器时，它会继承启动它的那个CoroutineScope的上下文与分发器
    对于该示例来说，它会继承runBlocking的上下文，而runBlocking则是运行在main线程当中。
    2.Dispatchers.Unconfined是一种很特殊的协程分发器，它在该示例中也是运行在main线程中，
    但实际上，其运行机制与不指定协程分发器时是完全不同的。
 */

fun main() = runBlocking<Unit> {
    launch {
        println("no params   ,thread: ${Thread.currentThread().name}")
    }
    //不理解为啥launch声明的参数没有Dispatchers，但是传了个Dispatchers做参数
    launch(Dispatchers.Unconfined) {
        println("Dispatchers.Unconfined   ,thread: ${Thread.currentThread().name}")
        //delay方法加或者不加 加在前面或者后面都会影响执行的线程
        delay(100)
    }
    launch(Dispatchers.Default) {
        println("Dispatchers.Default   ,thread: ${Thread.currentThread().name}")
    }
    launch(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) {
        println("Single Thread Executors   ,thread: ${Thread.currentThread().name}")
    }
}