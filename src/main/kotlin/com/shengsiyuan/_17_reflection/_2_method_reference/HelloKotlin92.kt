package com.shengsiyuan._17_reflection._2_method_reference

/*
    函数引用（方法引用）
    方法引用支持重载
    multiplyBy3表示 (Int) -> Int 的值
    multiplyBy3表示 (Char) -> Int 的值
 */
fun multiplyBy3(x: Int): Int {
    return 3 * x
}

fun multiplyBy3(x: Char): Int {
    return 3 * x.toInt()
}

fun main() {
    val values = listOf(1, 2, 3, 4, 5, 6)
    val valueStr = charArrayOf('a', 'b', 'c')
    //方法引用
    println(values.map(::multiplyBy3))
    println(valueStr.map(::multiplyBy3))

    val str = "abcde"
    println(str.myReference3(2))
}

val myReference: (Int) -> Int = ::multiplyBy3
val myReference2: (Char) -> Int = ::multiplyBy3
val myReference3: String.(Int) -> Char = String::get