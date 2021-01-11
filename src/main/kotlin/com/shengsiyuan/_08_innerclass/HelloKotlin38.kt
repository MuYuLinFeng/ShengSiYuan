package com.shengsiyuan._08_innerclass

//在运行的时候 外部类创建实例后 内部类回持有外部类的引用 能够访问外部类的成员变量和方法
class Person(val name: String, val age: Int) {
    private val str: String = "Person属性"

    private inner class PersonFeature(var height: Int, var weight: Int) {
        private val str: String = "PersonFeature属性"

        fun getPersonFeature() {
            val str: String = "局部变量"
            println("姓名：$name, 年龄：$age, 身高：$height, 体重：$weight")
            this@Person.method()

            println(this@Person.str)
            println(this.str)
            println(str)
        }
    }

    private fun method() {
        println("执行了Person的method方法")
    }

    fun getPerson() {
        val personFeature = PersonFeature(174, 74)
        personFeature.getPersonFeature()
    }
}

fun main() {
    val person = Person("张三", 20)
    person.getPerson()
}