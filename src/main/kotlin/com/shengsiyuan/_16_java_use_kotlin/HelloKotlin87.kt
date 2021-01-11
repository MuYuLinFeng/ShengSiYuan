package com.shengsiyuan._16_java_use_kotlin

/*
    @JvmOverloads 促使编译器生成额外的重载构造方法
    (解决Kotlin有默认值Java没有默认值的适配问题)
    这里是：
    MyClass2(x:Int)
    MyClass2(x:Int,y:String)
 */
class MyClass2 @JvmOverloads constructor(x: Int,
                                         y: String = "hello",
                                         z: String = "world") {
    fun myMethod(a: Int, b: String, c: Int = 3) {
        println("a:$a b:$b c:$c")
    }
}