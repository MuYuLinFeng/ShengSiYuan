package com.shengsiyuan._02_differjava

fun main() {
    var array = listOf<String>("hello", "world", "hello world", "welcome", "goodbye")
    for (item in array) {
        println(item)
    }
    when {
        "world" in array -> {
            println("world in collection")
        }
    }
    println("------------------")
    array.sorted().forEach { if (it.length > 5) println(it.toUpperCase()) }
    println("------------------")
    array.filter { it.length > 5 }.map { it.toUpperCase() }.sorted().forEach { println(it) }
}