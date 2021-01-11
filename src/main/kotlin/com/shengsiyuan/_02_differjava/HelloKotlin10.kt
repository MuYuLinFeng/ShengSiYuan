package com.shengsiyuan._02_differjava

fun main() {
    var a: String = "hello \\n world"
    println(a)


    var b: String = """ hello
       \n | world
    """.trimMargin()
    println(b)
}