package com.shengsiyuan._07_genericity

//泛型 generics 变量类型的参数化

class MyGeneric<T>(t: T) {
    var variable: T

    init {
        this.variable = t
    }
}

fun main() {
    val myGeneric: MyGeneric<String> = MyGeneric<String>("hello world")
    println(myGeneric.variable)

    val myGeneric2 = MyGeneric("hello world")//Kotlin类型推断 尖括号可以省略
    println(myGeneric2.variable)
    println("---------------------------")
    val myClass = MyClass<String, Number>("abc", 3.2)
    myTest(myClass)
}

class MyClass<out T, in M>(t: T, m: M) {
    private var t: T
    private var m: M

    init {
        this.t = t
        this.m = m
    }

    fun get(): T = this.t

    fun set(m: M) {
        this.m = m
        println(m is Number)
    }
}

fun myTest(myClass: MyClass<String, Number>) {
    val myObject: MyClass<Any, Int> = myClass
    println(myObject.get())//读取Any  写入都是Number
}