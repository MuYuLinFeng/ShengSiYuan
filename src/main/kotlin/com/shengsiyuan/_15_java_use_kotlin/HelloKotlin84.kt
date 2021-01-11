package com.shengsiyuan._15_java_use_kotlin

class MyClass2 {
    companion object {
        fun test1() {
            println("test1")
        }
        /*
            JvmStatic修饰伴生对象中定义的函数后
            编译器会在相应MyClass2对象的类中生成静态方法，
            也会在Companion对象自身中生成实例方法
         */
        @JvmStatic
        fun test2() {
            println("test2")
        }
    }
}