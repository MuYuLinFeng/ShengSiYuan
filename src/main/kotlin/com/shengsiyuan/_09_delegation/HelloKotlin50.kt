package com.shengsiyuan._09_delegation

import kotlin.properties.Delegates

// 非空属性
// notNUll 适用于那些无法再初始化阶段无法确认属性值的场合
class MyPerson {
    var address: String by Delegates.notNull<String>()
}

/*
    可观测属性（Observable）
    Delegates.observable 接受两个参数与修改处理器
    处理器会在我们每次对属性赋值时得到调用（在赋值完成之后被调用）
    处理器本身接收3个参数：被赋值的属性本身，就得属性值与新的属性值

    Delegates.vetoable 在赋值之前调用，可以当作拦截器使用
 */

class Person {
    var age: Int by Delegates.observable(0) { prop, oldValue, newValue ->
        println("${prop.name}, oldValue: $oldValue, newValue: $newValue")
    }

    var name: String by Delegates.vetoable("") { prop, oldValue, newValue ->
        println("${prop.name}, oldValue: $oldValue, newValue: $newValue")
        if (newValue == "hml") {
            return@vetoable true
        }
        return@vetoable false
    }
}

fun main() {
    val person = Person()
    person.age = 30
    person.age = 40
    println("--------------")


    person.name = "hml"
    println("name ${person.name}")
    person.name = "cn"
    println("name ${person.name}")
    println("--------------")


    val myPerson = MyPerson()
    myPerson.address = "suzhou"
    println(myPerson.address)
}