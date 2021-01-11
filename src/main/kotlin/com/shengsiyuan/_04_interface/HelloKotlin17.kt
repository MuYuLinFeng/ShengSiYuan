package com.shengsiyuan._04_interface

interface A {
    fun method() {
        //接口方法可以有实现
        println("A")
    }
}

open class B {
    open fun method() {
        //接口方法可以有实现
        println("B")
    }
}

//多继承相同签名的方法 必须显示override ，supper必须加<>
class C : A, B() {
    override fun method() {
        super<A>.method()
        super<B>.method()
        println("C")
    }
}

fun main() {
    var c = C()
    c.method()
}