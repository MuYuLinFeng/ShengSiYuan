package com.shengsiyuan._17_reflection._5_get_property_function

import com.shengsiyuan._08_innerclass.MyInterface
import java.io.Serializable
import kotlin.reflect.full.superclasses

class MySerializable : Serializable, MyInterface {
    override fun myPrint(i: Int) {

    }
}

fun main() {
    val mySerializable = MySerializable::class
    println(mySerializable.superclasses)
}