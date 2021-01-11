package com.shengsiyuan._10_function

import com.sun.xml.internal.ws.api.ha.StickyFeature

/*
    解构声明
*/

data class MyResult(val result: String, val status: Int)

fun myMethod(): MyResult {
    return MyResult("Success", 1)
}

fun myMethod2(): Pair<String, Int> {
    return Pair("Success", 1)
}

fun myMethod3(): Triple<String, String, String> {
    return Triple("", "", "")
}

fun main() {
    val myResult = myMethod()

    val (result, status) = myMethod()

    println(result)
    println(status)

    val (result2, status2) = myMethod2()
    println(result2)
    println(status2)

}