package com.shengsiyuan._14_kotlin_use_java

/*
    数组（Array）

    //参考MyTest.java (协变)
    在Kotlin中array是不变（非协变逆变）,这一点与Java存在明显的不同。
    这意味着，我们无法将一个Array<String>赋给Array<Any>，这样就可以防止可能出现的运行时异常

    Kotlin提供了原生类型数组来避免自动装箱和拆箱带来的成本：
    IntArray,
    DoubleArray,
    CharArray,
    ByteArray,
    ShortArray,
    LongArray,
    FloatArray,
    BooleanArray
 */

fun main() {
    val myArray = HelloKotlin75Java()
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    myArray.myArrayMethod(intArray)

    println("----------------")
    //当编译为JVM字节码时，编译器会优化对于数组的访问，使之不会产生额外的成本

    val array = arrayOf(1, 2, 3, 4)
    array[0] = array[0] * 2 //这样使用的时候实际上并不会调用set或者get方法
    for (x in array) {
        //这里并不会生成中间对象，直接通过下标拿数据
        println(x)
    }
}