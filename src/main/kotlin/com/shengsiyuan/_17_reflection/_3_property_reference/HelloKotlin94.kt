package com.shengsiyuan._17_reflection._3_property_reference

/*
    属性引用
    属性引用的用法与函数引用的用法完全一致 都是通过 :: 来引用

    ::a 表示类型KProperty<Int>的属性对象，我们可以通过get()来获取值，也可以通过name属性来获取名字
    对于可变属性来说 比如var b = 5，::b返回的使 KMutableProperty<Int>的值，它拥有一个set()方法
 */

const val a = 3
var b = 5
fun main() {
    println(::a)
    println(a)
    println(::a.get())
    println(::a.name)
    println("--------------")
    ::b.set(20)
    println(::b.get())
}