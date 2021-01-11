package com.shengsiyuan._17_reflection._4_constructor_reference

import java.lang.management.ManagementFactory

/*
    构造方法引用
    两点要求：
    函数对象的参数要与构造方法的参数保持一致（参数个数和类型）
    函数对象的返回结果要与构造方法所在类的类型保持一致
 */

class B(val x: Int)

fun myMethod(factory: (x: Int) -> B) {
    val b = factory(3)
    println(b::class.java)
    println(b.x)
}

fun main() {
    myMethod(::B)
}