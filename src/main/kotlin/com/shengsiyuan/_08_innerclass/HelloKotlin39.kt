package com.shengsiyuan._08_innerclass

class OuterClass4 {
    class NestedClass4 {
        init {
            println("NestedClass4构造方法执行")
        }
    }
}

fun main() {
    //静态成员隶属于外部类的class对象 而不是外部类，所以会在初始化的时候就进行优先初始化
    val nestedClass4: OuterClass4.NestedClass4 = OuterClass4.NestedClass4()
}