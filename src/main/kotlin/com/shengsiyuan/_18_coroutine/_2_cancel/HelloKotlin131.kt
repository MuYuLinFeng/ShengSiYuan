package com.shengsiyuan._18_coroutine._2_cancel

/*
    kotlinx.coroutines包下的所有挂起函数都是可以取消的
    他们会检查协程的取消状态，当取消时就会抛出CancellationException异常（运行期异常）
    不过，如果协程正在处于某个计算过程当中，并且没有检查取消状态，那么他就是无法被取消的。
 */

