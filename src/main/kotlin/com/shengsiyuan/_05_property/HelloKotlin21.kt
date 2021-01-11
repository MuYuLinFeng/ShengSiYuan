package com.shengsiyuan._05_property

//非抽象类的非空类型属性必须构造方法中初始化 或者lateinit修饰
// lateinit只能用在类体中声明的var属性上，不能用在一级构造方法上声明的属性上
// 属性不能拥有自定义的setter getter方法
// 属性类型需要为非空，且不能是原生数据类型（Int Float Boolean）
class TheClass {
    lateinit var name: String //延迟初始化 kotlin不会再检测类生成对象的时候属性是否初始化

    fun initName() {
        this.name = "张三"
    }

    fun printName() {
        println(name)
    }
}

fun main() {
    var theClass = TheClass()
    theClass.initName()
    theClass.printName()
}