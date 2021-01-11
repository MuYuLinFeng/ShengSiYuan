package com.shengsiyuan._08_innerclass
/*
    类似Java的匿名内部类，Kotlin对象表达式中的代码食可以访问到外层的变量的。
    与Java不同的是，外层变量无需声明为final
 */


fun main() {
    var i = 100
    val myObject = object {
        fun myMethod() {
            i++
        }
    }

    myObject.myMethod()
    println(i)
}