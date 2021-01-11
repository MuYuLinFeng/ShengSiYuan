package com.shengsiyuan._03_class

open class MyParent {
    open val name: String = "parent"
    val test: String = "test"
}

class MyChild : MyParent() {
    override val name: String = "child"
}

fun main() {
    val myChild = MyChild()
    println(myChild.name)
    println(myChild.test)
    println("-----------------------")
    val myChild3 = MyChild3()
    myChild3.method()
    println("-----------------------")
    println(myChild3.name)

}

//在构造方法中声明重写的属性
class MyChild2(override val name: String) : MyParent() {
}

open class MyParent3() {
    open fun method() {
        println("parent method")
    }

    open val name: String get() = "parent"
}

class MyChild3 : MyParent3() {
    override fun method() {
        super.method()
        println("child method")
    }

    //val可以被val var覆盖  var可以重写var
    // 因为var是变量 同时有get set方法 但是val是常量只有get方法
    override val name: String get() = super.name + " add child"
}