package com.shengsiyuan._08_innerclass

// 对象表达式
//Java当中匿名内部类在很多场景下都得到了大量使用
//Kotlin的对象表达式就是为了解决匿名内部类的一些缺陷而产生
/*
    1.匿名内部类是没有名字的类
    2.匿名内部类一定是继承了某个父类，或者是实现了某个接口
    3.Java运行时会将该匿名内部类当做他所实现的接口或是所继承的父类来看待
*/

/*
    对象表达式的格式：
    object [:若干个父类型，中间逗号分隔]{
    }
*/

interface MyInterface {
    fun myPrint(i: Int)
}

abstract class MyAbstractClass {
    abstract val age: Int
    abstract fun printMyAbstractClassInfo()
}

class Test {
   val myObject = object : MyInterface {
        override fun myPrint(i: Int) {
            println(i)
        }
    }

    fun HaHa() {
        myObject.myPrint(20)
    }
}

fun main() {
    //一个匿名内部类实现了MyInterface接口 并返回了这个匿名类
    val myObject = object : MyInterface {
        override fun myPrint(i: Int) {
            println(i)
        }
    }
    myObject.myPrint(100)

    //这个匿名内部类没有实现任何的接口或者抽象类
    val myObject2 = object {
        init {
            println("初始化块执行")
        }

        var myProperty = "hello world"
        fun myMethod() = "myMethod()"
    }
    println(myObject2.myProperty)
    println(myObject2.myMethod())


    val myObject3 = object : MyInterface, MyAbstractClass() {
        override fun myPrint(i: Int) {
            println(i)
        }

        override val age: Int
            get() = 30

        override fun printMyAbstractClassInfo() {
            println("printMyAbstractClassInfo invoked")
        }
    }
    println(myObject3.myPrint(100))
    println(myObject3.age)
    myObject3.printMyAbstractClassInfo()

}