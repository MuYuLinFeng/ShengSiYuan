package com.shengsiyuan._03_class

//private val 这样写的是成员变量
class Student constructor(private val username: String, private val age: Int, private val address: String) {

    fun printInfo() {
        println("三参构造：${this.username}, ${this.age}, ${this.address}")
    }
}


//如果一级构造方法所有参数都有默认值的话 编译器会自动生成一个没有参数的构造方法  并且使用全参构造方法的默认值
class Student2 constructor(
    private val username: String = "ewasd",
    private val age: Int = 2,
    private val address: String = "堵塞"
) {

    fun printInfo() {
        println("三参构造：${this.username}, ${this.age}, ${this.address}")
    }
}


fun main() {
    val person = Student("aaa", 99, "bbb")
    person.printInfo()

    val person2 = Student2()
    person2.printInfo()

    val person3 = Student2(age = 88)
    person3.printInfo()
}