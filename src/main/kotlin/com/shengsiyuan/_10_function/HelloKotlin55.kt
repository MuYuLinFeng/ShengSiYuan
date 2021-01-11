package com.shengsiyuan._10_function

/*
   中缀符号（infix notation）

   函数通过中缀符号的形式来调用，需要满族如下三个条件

   1.是成员函数或者扩展函数
   2.拥有单个参数
   3.声明时使用infix关键字
 */
class InfixTest(private var a: Int) {
    infix fun add(b: Int) = this.a + b
}

fun main() {
    val infixTest = InfixTest(2)
    //以下两种方式等价
    println(infixTest.add(5))
    println(infixTest add 5)
}

