package com.shengsiyuan._08_innerclass

//嵌套类
class OuterClass {
    private val str: String = "hello world"

    class NestedClass {
        fun nestedMethod() = "welcome"
        //这是不能访问的 因为嵌套类相当于静态内部类 静态内部类不能访问外部类的非静态成员和方法
        //静态成员隶属于外部类的class对象 而不是外部类，所以会在初始化的时候就进行优先初始化
        //可以访问同一个外部类当中的别的静态类，因为大家都是静态的 同级别
        //this@OuterClass.str
    }

    class NestedClass2{
        var nestedClass = NestedClass()
        fun show(){
            //可以访问同一个外部类当中的别的静态类，因为大家都是静态的 同级别
            println(nestedClass.nestedMethod())
        }
    }
}

fun main() {
    println(OuterClass.NestedClass().nestedMethod())
}