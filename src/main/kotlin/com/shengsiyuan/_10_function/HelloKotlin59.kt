package com.shengsiyuan._10_function

fun main() {
    val strings = arrayOf("hello", "world", "helloWorld", "welcome")

    strings.filter {
        it.contains("h")
    }.forEach { println(it) }
    println("================")

    strings.filter { item ->
        item.length > 5
    }.forEach { println(it) }
    println("================")

    strings.map { item ->
        if (item.contains("h", true)) {
            println(item)
        }
    }
    println("================")

    strings.filter { item ->
        item.endsWith("d", false)
    }.forEach { println(it.toUpperCase()) }
    println("================")
}