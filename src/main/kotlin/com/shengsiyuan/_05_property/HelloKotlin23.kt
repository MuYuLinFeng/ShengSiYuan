package com.shengsiyuan._05_property

// 扩展：extension
class ExtensionTest {
    fun add(a: Int, b: Int) = a + b
    fun subtract(a: Int, b: Int) = a - b
}

fun main() {
    var extensionTest = ExtensionTest()
    println("-----------------")
    println(extensionTest.add(1, 2))
    println("-----------------")
    println(extensionTest.subtract(1, 2))
    println("-----------------")
    println(extensionTest.multiply(2, 2))
    myPrint()
    println("-----------------")
    CC().foo()
    println("-----------------")
    CC().foo(1)
    println("-----------------")
    val int: Int? = null
    println(int.toString())
}

fun ExtensionTest.multiply(a: Int, b: Int) = a * b
//扩展方法
/* 扩展函数的解析是静态的 并不会插入原类
*  扩展函数的解析是静态分发的，而是不是动态的，即扩展时不支持多态的 调用值取决于对象的声明类型（Java取决于实例化的对象类型 即动态解析）
*  调用是由对象的声明类型决定的，而不是由对象的实际类型决定的
* */

open class AA
open class BB : AA()

fun AA.a() = "a"
fun BB.a() = "b"
fun myPrint() {
    var aa: AA = AA()
    var bb: AA = BB()
    println("-----------------")
    println(aa.a())
    println("-----------------")
    println(bb.a())
}

//扩展方法和既有方法签名完全相同 既有函数优先级更高
class CC {
    fun foo() {
        println("member")
    }
}

fun CC.foo() {
    println("member2")
}

fun CC.foo(i: Int) {
    println("member3")
}

//对可空类型扩展
fun Any?.toString(): String {
    return when (this) {
        null -> {
            "null"
        }
        else -> {
            toString()
        }
    }
}