package com.shengsiyuan._05_property

class ThePerson(address: String, name: String) {
    //java中的成员变量 kotlin中的属性
    //只读属性用val声明  只有get方法  没有set方法
    val age: Int
        get() = 21

    //var表示变量 可读可写 get set都有
    var address: String = address
        get() {
            println("get invoked")
            //field 只能用在属性的get set中 表示背后真正存值的事物
            return field
        }
        set(value) {
            println("set invoked")
            field = value
        }

    var name: String = name
//        private set //不可被访问
//        private get //不可被访问 并且访问权限和属性一致才行

    //backing filed 支撑字段（域）
    //get set里面没有此字段直接返回本身属性名会堆栈溢出

    //baking property 支撑属性（private属性）
}

fun main() {
    var person = ThePerson("shakalaka", "www")

    //kotlin的内部其实是调用了get方法
    println(person.age)
    println("-----------------------------")
    println(person.address)
    println("-----------------------------")
    person.address = "天津"
    println("-----------------------------")
    println(person.address)


    println("-----------------------------")
    println(person.name)
    println("-----------------------------")
    person.name = "lisi"
    println(person.name)
}