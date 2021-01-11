package com.shengsiyuan._03_class

open class Fruit {
    //可被覆盖的方法也必须写上 open
    //可被复写的方法也必须有方法体
    open fun name() {
        println("fruit")
    }

    fun expirationData() {
        println("1 month")
    }
}

open class Orange : Fruit() {
    //此类的子类不可再覆盖此方法 因为修饰了 final
    final override fun name() {
        println("Orange")
    }
}

class Apple : Fruit() {
    override fun name() {
        println("apple")
    }
}

fun main() {
    var apple = Apple()
    apple.name()
    apple.expirationData()
}