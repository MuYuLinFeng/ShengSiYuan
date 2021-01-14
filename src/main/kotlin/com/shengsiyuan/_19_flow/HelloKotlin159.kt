package com.shengsiyuan._19_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

/*
    Flow builder(流构建器)

    1.flow是最经常被使用的一种流构建器
    2.flowOf(...) 构建器可用于定义能够发射固定数量值的流
    3.对于各种集合与序列来说，他们都提供了asFlow扩展方法来将自身转换成Flow

    channelFlow { ... }
    MutableStateFlow
    MutableSharedFlow

    inline，noinline，crossinline
    non-local returns 非局部返回 函数内部的函数直接返回一个值作为外部函数的返回值
    非局部返回的前提要求外部方法是一个inline的

    crossinline 标识的方法不允许非局部返回

 */

fun main() = runBlocking {
    (1..5).asFlow().collect {
        println("asFlow $it")
    }
    flowOf(500, 20, 321, 54).collect {
        println("flowOf $it")
    }
}