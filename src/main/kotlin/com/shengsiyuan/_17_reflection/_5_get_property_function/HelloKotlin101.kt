package com.shengsiyuan._17_reflection._5_get_property_function

class MyTestClass<K, V> {
    var k: K? = null
    var v: V? = null
}

fun main() {
    val myTestClass = MyTestClass::class
    println(myTestClass.typeParameters)
    println(myTestClass.typeParameters.size)
}