package com.shengsiyuan._11_collection

fun main() {
    val map = mapOf("a" to "aa", "b" to "bb", "c" to "cc")
//    val map = mapOf("a" to "aa", "b" to "bb", "c" to 1)

    println("\nprint by map")
    map.map { println(it) }
    println("\nprint by key value")
    for ((key, value) in map) {
        println("key:${key} value:${value}")
    }
    println()
    println("print by key")
    map.mapKeys { println(it.key) }
    println()
    println("print by value")
    map.mapValues { println(it.value) }
    println()
    println("print by value")
    map.mapValues { "${it.value} hello" }.forEach { println(it) }

    println()
    println("print by 解构声明")
    map.mapValues { (_, value) -> "$value hello" }.forEach { println(it) }

    //Kotlin 允许我们为解构声明整体指定类型，也可以为每一个具体的component指定类型
    println()
    println("print by 解构声明")
    map.mapValues { (_, value): Map.Entry<String, String> -> "$value hello" }.forEach { println(it) }
    println()
    println("print by 解构声明")
    map.mapValues { (_, value: String): Map.Entry<String, String> -> "$value hello" }.forEach { println(it) }
}