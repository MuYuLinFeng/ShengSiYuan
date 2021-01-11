package com.shengsiyuan._08_innerclass

class MyClass {
    /*
        匿名对象只能在局部变量范围内（某个方法内部）
        或是被private修饰的成员变量范围内才能被识别出其真正的类型（类成员）

        如果将匿名对象当作一个public方法的返回类型或是public属性的类型，
        那么该方法或是属性的真正类型就是改匿名对象所声明的父类型，
        如果没有声明任何父类型，那么其类型就是Any；
        在这种情况下，匿名对象中所声明的任何成员都是无法访问的

        如果有父类则可以用protected public private default 修饰
        这时候匿名对象的类型是其父类型 可访问其父类的成员
        @com.shengsiyuan._08_innerclass.Test
    */
    private var myObject = object {
        fun outPut() {
            println("output invoked")
        }
    }

    fun myTest() {
        //private 修饰后才能在 myTest 中访问
        myObject.outPut()

        //访问对象的类型
        println(myObject.javaClass)
        println(myObject::class.java)
    }
}

class MyClass2 {
    private fun method1() = object {
        val str = "hello"
    }

    internal fun method2() = object {
        //这里返回的是Any类型 所以不能再test访问str
        val str = "world"
    }

    fun test() {
        method1().str
    }
}

fun main() {
    val myClass = MyClass()
    myClass.myTest()
}