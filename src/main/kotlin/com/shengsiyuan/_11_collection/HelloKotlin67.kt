package com.shengsiyuan._11_collection

fun main() {
    val items = listOf(1, 2, 3, 4)
    println(items.first())
    println(items.last())
    println("-------------")
    println(items.indexOfFirst { it == 2 })
    println("-------------")
    println(items.lastIndex)
    println(items.lastOrNull())

    println("-------------")
    items.filter { it % 2 == 0 }.forEach { println(it) }

    println("-------------")
    val myList = mutableListOf(1, 2, 3)
    println(myList.requireNoNulls())

    println("-------------")
    if (myList.none { it > 10 }) {
        println("没有大于十的数")
    }
    println("-------------")

    println("-------------")
    println(myList.firstOrNull())
    println(myList.lastOrNull())
    println("-------------")

    val myMap = hashMapOf("hello" to 100, "world" to 200)
    println(myMap["hello"])


    val myMap2 = HashMap(myMap)
    println(myMap2)
}