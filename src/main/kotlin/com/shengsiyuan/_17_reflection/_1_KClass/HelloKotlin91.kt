package com.shengsiyuan._17_reflection._1_KClass
open class Parent

class Son : Parent() {

}

class Daughter : Parent() {

}

fun main() {
    val son: Parent = Son()
    val daughter: Parent = Daughter()

    println(son::class)
    println(son::class.java)
    println("----------")
    println(daughter::class)
    println(daughter::class.java)
}