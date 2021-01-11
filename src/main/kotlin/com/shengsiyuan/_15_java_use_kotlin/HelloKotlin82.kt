package com.shengsiyuan._15_java_use_kotlin
/*
    JvmField注解过的字段，此字段会被当做实例字段（instance field）
    Kotlin编译器在处理的时候将不会给这个字段生成getter setter方法
 */
class Person {
    var name = "zhangsan"

    @JvmField
    var age = 10
}