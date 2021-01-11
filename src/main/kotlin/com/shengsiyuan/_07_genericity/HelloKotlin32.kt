package com.shengsiyuan._07_genericity

import org.junit.Assert.assertTrue

/*
    Kotlin的使用处协变(use-site variance)、类型投影(type projection)
*/

//数组的浅拷贝
// 加out后 Array是有限制的 只能调用from中的get方法 不能做set操作
fun copy(from: Array<out Any>, to: Array<Any>) {
    assertTrue(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun main() {
    val from: Array<Int> = arrayOf(1, 2, 3, 4)
    //val to1: Array<Any> = Array(4, { it -> "hello $it" })
    //val to2: Array<Any> = Array(4, { "hello $it" })
    //val to3: Array<Any> = Array(4, { _ -> "hello" })
    val to: Array<Any> = Array(4) { it -> "hello $it" }

    copy(from, to)
    for (i in to) {
        println(i)
    }
    println("--------------------")
    val dest: Array<String> = Array<String>(4) { "hello" }
    setValue(dest, 1, "world");
    for (i in dest) {
        println(i)
    }
    println("--------------------")
    val dest2: Array<Any> = Array<Any>(4) { "hello" }
    setValue(dest2, 1, "world")
    for (i in dest2) {
        println(i)
    }
}

// 加in 接收 String 父类型和本身
// 实例类型是Array<Any> 对 Any 写入 String 可以
fun setValue(to: Array<in String>, index: Int, value: String) {
    to[index] = value
}