package com.shengsiyuan._06_dataclass


//密封类 sealed class
/*
    根本上有点像枚举类 表示父子类的限制型结构
    密封类的子类的实例可以有多个 直接子类定义在密封类同一个文件内 间接子类可以在任何地方
    密封类是抽象类 不可实例化 可以有抽象成员 只能有私有构造方法
    枚举的扩展 密封类可以有子类 子类可以创建无数多个子类
*/

sealed class Calculator

object Add : Calculator()
object Subtract : Calculator()
open class Multiply : Calculator()

//间接子类 可以在任何地方
class HaHa : Multiply()

fun calculate(a: Int, b: Int, calculator: Calculator) = when (calculator) {
    is Add -> a + b
    is Subtract -> a - b
    is Multiply -> a * b
}

fun main() {
    println(calculate(2, 2, Add))
    println(calculate(2, 2, Subtract))
    println(calculate(2, 7, Multiply())) //有子类后的直接子类 使用的时候需要创建对象
}