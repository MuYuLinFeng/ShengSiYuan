package com.shengsiyuan._18_coroutine

fun main() {
    test(5, action = {
        println("hello world")
    })
    test2(5, action = { int ->
        println("hello world $int")
    })
}

fun test(x: Int, action: () -> Unit) {
    action()
}

fun test2(x: Int, action: (Int) -> Unit) {
    action(100)
}