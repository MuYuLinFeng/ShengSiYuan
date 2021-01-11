package com.shengsiyuan._05_property

// 可见性
// private protected internal public


//顶层声明的时候
// 如果不写修饰符默认是public 任何地方都能用
// private 只能在当前文件可用
// internal 同一个模块下可用
// protected 不能修饰顶层声明
fun method() {//函数的顶层声明

}

class Clazz //类的顶层声明


class Clazz1 {
    //类里面的方法和属性
    // private 类内部使用
    // protected 当前类和子类使用
    // internal 同一个模块下可用
    // public 任何地方可用
}

open class Clazz2 {
    private val b = 3
    protected val c = 4
    internal val d = 5
}

class subClazz : Clazz2() {
    //c d 可用
}

open class Clazz3 {
    //d 可用
}