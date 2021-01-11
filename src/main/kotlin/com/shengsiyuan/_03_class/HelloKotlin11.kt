package com.shengsiyuan._03_class

//默认就是public 不用和文件名相同
//这是一个空类
class Empty

//一级构造方法 是类头的一部分 位于类名后面 可以带有参数
class MyClass private constructor(userName: String) {

}

//如果以及构造方法没有任何注解货是可见性关键字修饰 那么constructor可以省略
class MyClass2(var userName: String = "BB") {
    init {
        //初始化代码块
        println(userName)
        println("---------------------")
        println(userName.toLowerCase())
        println("---------------------")
        userName = "AA"
        println(userName)
        println("---------------------")
    }
}

fun main() {
    MyClass2("CC")
    MyClass2()
}