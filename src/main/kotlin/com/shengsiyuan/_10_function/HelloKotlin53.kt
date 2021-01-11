package com.shengsiyuan._10_function
//方法和函数的区别
//方法位于类中
//行数位于类之外可独立使用

//默认参数
fun test(a: Int = 0, b: Int = 1) = println("$a - $b = ${a - b}")

fun main() {
    test()
    test(9, 3)
    test(9)
    test(a = 3)
    test(b = 22)

    val b = B()
    println(b.method(a = 3, b = 1))
    println(b.method(a = 3))
    println(b.method(3, 1))

    test2(b = 7)

    test3(3, 4, ::test)
    test3(6, 2, compute = { a, b -> println(a * b) })
    test3(6, 2, { a, b -> println(a * b) })
    test3(6, 6) { a, b -> println(a * b) }
    test3(44) { a, b -> println(a * b) }
    test3(b = 44) { a, b ->
        val c = a + b
        println(a * b * c)
    }
    test3() { a, b -> println(a * b) }

    test4(1, 2, 3, 4)

    test4("a", "b", "c")

    val str = arrayOf("a", "b", "c")
    //* spread operator 分散运算符
    test4(strings = *str)
    /*
        在Kotlin中调用Java方法时不能使用具名参数语法，因为Java字节码并不总是会保留参数名信息
     */
}

/*
    如果一个默认参数位于其他无默认参数值的参数的前面，
    那么默认值只能通过在调用函数时使用具名参数的方式来使用
 */
fun test2(a: Int = 1, b: Int) = println("$a - $b = ${a - b}")

/*
    如果函数的最会后一个参数是lambda表达式，而且在调用的时候是位于圆括号外，
    那么就可以不指定lambda表达式的具名参数
 */
fun test3(a: Int = 1, b: Int = 2, compute: (x: Int, y: Int) -> Unit) {
    compute(a, b)
}

/*
    具名参数
    在调用函数时，函数参数可以是具名的
    当一个函数有大量参数或是一些参数有默认值时。这种调用是比较方便的
 */
fun test4(a: Int = 1, b: Int, c: Int, d: Int) = println("$a - $b - $c - $d= ${a - b - c - d}")
/*
    在调用函数时，如果同时使用了位置参数与具名参数，那么所有的位置参数都必须要位于第一个具名参数之前
    比如说：foo(1, x = 2)是允许的，不过foo(x = 1, 2)是不允许的
 */

fun test4(vararg strings: String) {
    println(strings.javaClass)
    strings.forEach { println(it) }
    strings.forEach(::println)
}
/*
    方法的重写：
    子类所拥有的重写方法会使用与父类相同的默认参数值
    在重写一个拥有默认参数值的方法时，方法签名中必须将默认参数值省略
 */

open class A {
    open fun method(a: Int, b: Int = 4) = a + b
}

class B : A() {
    override fun method(a: Int, b: Int) = a + b
}