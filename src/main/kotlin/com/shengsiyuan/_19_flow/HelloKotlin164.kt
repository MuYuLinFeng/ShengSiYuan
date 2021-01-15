package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/*
    Flow是顺序执行的
   对于Flow的收集操作来说，它是运行在调用了终止操作的那个协程上，在默认情况下，它是不会自动新的协程的，
   每个emit的元素都会由所有的中间操作进行处理，最后再由终止操作进行处理。本质上，就是由上游进入到下游。
   上一个元素走完了所有操作到终止操作后，下一个元素才开始操作。
 */

fun main() = runBlocking {
    (1..10).asFlow().filter {
        println("filter $it")
        it % 2 == 0
    }.map {
        println("map $it")
        "Hello Map $it"
    }.collect { println("Colloct $it") }
}