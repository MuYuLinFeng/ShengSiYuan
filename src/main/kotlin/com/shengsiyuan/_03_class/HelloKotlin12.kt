package com.shengsiyuan._03_class

//非抽象类 无构造方法的时候 编译器会自动生成无参数无返回值构造方法（public）
class Person private constructor(username: String) {
    //必须有一个初始化值或者放在初始化模块
    private var userName: String
    private var age: Int
    private var address: String

    init {//初始化代码块和主构造方法是匹配的
        println("默认构造：$username")
        this.userName = username
        this.age = 20
        this.address = "beijing"
    }

    //二级构造方法必须直接或者间接的调用一级构造方法
    //二级构造方法的初始化体在构造方法的方法体内部
    constructor (user: String, age: Int) : this(user) {
        println("两参构造：$user, $age")
        this.age = age
    }

    //二级构造方法的初始化体在构造方法的方法体内部
    constructor(user: String, age: Int, address: String = "beijing") : this(user, age) {
        this.address = address
        println("三参构造：${this.userName}, ${this.age}, ${this.address}")
    }
}

fun main() {
//    Person("aaa")
    Person("aaa", 99, "bbb")
}