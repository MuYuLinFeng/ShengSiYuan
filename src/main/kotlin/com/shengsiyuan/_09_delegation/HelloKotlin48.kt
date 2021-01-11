package com.shengsiyuan._09_delegation

import kotlin.reflect.KProperty

//属性委托
//operator 运算符的意思
/*
    有4种情况在实际开发中比较有用
    1.延迟属性
    2.可观测属性
    3.非空属性
    4.map属性
 */
class MyDelegate {
    //方法名必须是 getValue 签名也必须这样
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String =
        "$thisRef,your delegate property name is ${property.name}"

    //方法名必须是 setValue
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) =
        println("$thisRef, new value i $value")
}

class MyPropertyClass {
    var str: String by MyDelegate()
}

fun main() {
    val myPropertyClass = MyPropertyClass()
    myPropertyClass.str = "hello world"
    println(myPropertyClass.str)
}