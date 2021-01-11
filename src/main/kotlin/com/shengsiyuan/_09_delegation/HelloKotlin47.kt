package com.shengsiyuan._09_delegation

//类委托

interface MyInterface {
    fun myPrint()
}

class MyInterfaceImpl(val str: String) : MyInterface {
    override fun myPrint() {
        println("welcome $str")
    }
}
/*
    委托原理

    by关键字后面的对象实际上会被存在类的内部，编译器则会把父接口中的所有方法实现出来，并且将
    实现转移给委托对象来执行
 */
class MyClass(myInterface: MyInterface) : MyInterface by myInterface {
    //如果MyClass不提供myPrint 则执行myInterface的myPrint 否则执行自己的myPrint
    override fun myPrint() {
        println("hello world")
    }
}

fun main() {
    val myInterfaceImpl = MyInterfaceImpl("zhangsan")
    MyClass(myInterfaceImpl).myPrint()
}