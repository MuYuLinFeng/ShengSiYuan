package com.shengsiyuan._07_genericity

//泛型函数

fun <T> getValue(item: T): T {
    return item
}

fun main() {
    val item = getValue<Int>(3)
    println(item)

    val item1 = getValue("hello")
    println(item1)

    val upperBounds = UpperBoundsClass2<String>()
}

//T 只能是 List<T> 和 List<T>下面的类型
class UpperBoundsClass<out T : List<T>> {

}

class UpperBoundsClass2<T> where T : Comparable<T>, T : Any {

}