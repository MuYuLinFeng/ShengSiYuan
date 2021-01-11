package com.shengsiyuan._09_delegation

//延迟属性：指的是属性只在第一次被访问的时候才会计算，之后则会将之前的计算结果缓存起来供后续调用


//lambda表达式 如果方法的最后一个参数是lambda表达式，
// 那么可以把lambda表达式放到方法的外面用{}包起来

/*
    1.SYNCHRONIZED：默认情况下，延迟属性的计算是同步的，值只会在一个线程中得到计算，所有线程都会使用相同的结果。
    2.PUBLICATION：如果不需要初始化委托的同步，这样多个线程可以同时执行
    3.NONE：如果确定初始化操作只会在一个线程中执行，这样会减少线程安全方面的开销
 */
val myLazeValue: Int by lazy(LazyThreadSafetyMode.NONE) {
    println(" hello world")
    30
}

fun main() {
    println(myLazeValue)
    println(myLazeValue)
}