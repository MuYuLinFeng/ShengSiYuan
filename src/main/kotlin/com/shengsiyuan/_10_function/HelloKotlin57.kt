package com.shengsiyuan._10_function
/*
    高阶函数（high-order function）与lambda
    Lambda表达式格式要求：
    1.一个lambda表达式总是被一堆花括号包围
    2.其参数位于->之前，参数类型可以省略
    3.执行体位于->之后

    再kotlin中如果一个函数的最后一个参数是个函数，那么可以将lambda表达式作为实参传进去，
    并且可以在调用时方法园括号外去使用
*/

val multiply: (Int, Int) -> Int = { a, b -> a * b }
val add: (Int, Int) -> Int = { a, b -> a + b }
val subtract = { a: Int, b: Int -> a - b }
val myAction = { println("hello world") }

val myReturnNull: (Int, Int) -> Int? = { a, b -> a + b }
val myReturnNullL: (Int, Int) -> Int? = { _, _ -> null }

val functionMaybeNull: ((Int, Int) -> Int)? = null

fun myCalculate(a: Int, b: Int, calculate: (Int, Int) -> Int): Int {
    return calculate(a, b)
}

fun main() {
    println(myCalculate(1, 2, multiply))
    println(myCalculate(1, 2, add))
    println(myCalculate(1, 2, subtract))
}