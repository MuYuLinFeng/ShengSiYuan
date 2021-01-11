package com.shengsiyuan._14_kotlin_use_java

/*
    可变参数
 */
fun main() {
    val myVarargs = HelloKotlin76Java()
    val stringArrays = arrayOf("hello", "world", "hello world")
    myVarargs.myMethod(*stringArrays) //spread operation *
}