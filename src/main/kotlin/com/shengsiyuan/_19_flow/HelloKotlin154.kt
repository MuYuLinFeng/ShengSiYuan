package com.shengsiyuan._19_flow
/*
    Sequence
    如果在获取没一个元素时都需要执行一定的计算，这种计算是一种阻塞行为，将计算后的多个结果返回给调用端

    关于序列的特点：
    1.序列中的数据并非像集合那样一次性返回给调用端，而是计算完一个数据后就返回一个数据
    2.序列中的计算过程会使用主线程来进行，因此它会阻塞主线程的执行
 */

private fun myMethod(): Sequence<Int> = sequence {
    for (i in 100..105) {
        Thread.sleep(1000)//会阻塞主线程
        //yield v. 出产（产品或作物）；产出（效果、收益等）
        yield(i)//suspend方法
    }
}

fun main() {
    myMethod().forEach { println(it) }
    println("main")
}