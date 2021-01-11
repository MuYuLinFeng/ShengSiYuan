package com.shengsiyuan._16_java_use_kotlin

//扩展函数将被扩展的那个类作为扩展函数的第一个参数传递进去

//Java中的泛型不会存储到字节码叫做（类型擦除），依托于强制类型转换，所以是假泛型
//所以一下两个方法的签名在Java看来是一样的

fun List<String>.myFilter(): List<String> {
    return listOf("hello", "world")
}

@JvmName("myFilterJava")//重命名
fun List<Int>.myFilter(): List<Int> {
    return listOf(1, 2)
}

fun main() {
    val strList = listOf<String>()
    println(strList.myFilter())
    val intList = listOf<Int>()
    println(intList.myFilter())
}