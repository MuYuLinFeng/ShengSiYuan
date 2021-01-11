package com.shengsiyuan._04_interface

//对象声明 可以有方法和属性（和类一样）
object MyObject {
    fun method() {
        println("method")
    }
}

fun main() {
    //对象可以直接被调用 不用像类一样创建对象后再使用
    MyObject.method()
    MyTest.method() //调用方式有点静态方法 静态成员的感觉
}

//伴生对象
//在Java中有静态方法的替代（全局方法的概念）
//在Kotlin中类没有static方法
//在大多情况下 Kotlin推荐的做法是使用包级别的函数来做静态方法
//Kotlin会将包级别的函数当作静态方法来看待

//09 lesson
class MyTest {
    //伴生对象 伴随MyTest而存在 一个类只能有一个伴生对象
    //如果伴生对象没有名字 编译器会提供默认名字 Companion
    //相当于一个内部类
    //伴生对象看起来像是java中的静态成员 但是在运行期他们依旧是实例成员
    //在JVM上可以将伴生对象的成员真正生成为类的静态方法与属性 这是通过@jvmStatic注释来实现的
    //伴生对象在编译后会生成一个静态内部类
    companion object {
        var a: Int = 100

        @JvmStatic
        fun method() {
            println("method invoke")
        }
    }

    fun aaa() {
        method()
    }
}

//反编译 javap  查看字节码 javap -c 包名+类名
class D {
    companion object {
        @JvmStatic
        fun foo() {
            //此方法会成为D静态方法
        }

        fun bar() {
            //此方法其实是通过D内部的Companion静态实例来调用的
        }
    }
}
