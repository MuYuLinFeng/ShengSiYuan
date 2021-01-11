package com.shengsiyuan._02_differjava

fun main() {
    var array = intArrayOf(1, 2, 3, 4, 5)
    for (item: Int in array) {
        println(item)
    }

    for (index: Int in array.indices) {
        println(array[index])
    }

    array.forEach { println(it) }

    for ((index, value) in array.withIndex()) {
        println("array[${index}] = $value")
    }
}
