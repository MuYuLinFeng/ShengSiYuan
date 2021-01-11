package com.shengsiyuan._07_genericity

// star projection 星投影
// Star<out T> ：
// 如T的上界是TUpper，那么Star<*>就相当于Star<out T>
//表示当T的类型未知时，你可以安全的从Star<*>当中读取TUpper类型的值

// Star<in T> ：
//Star<*>就相当于Star<in Nothing>,这表示你无法向其中写入任何值


// Star<T> ：
// 如果T的上界是TUpper，那么Star<*>就相当于读取时的Star<out TUpper> 以及写入时的Star<in Nothing>

class Star<out T>
class Star2<in T> {
    fun setValue(t: T) {

    }
}

class Star3<T>(private var t: T) {
    fun setValue(t: T) {

    }

    fun getValue(): T {
        return t;
    }
}

fun main() {
    val star: Star<Number> = Star<Int>()
    val star2: Star<*> = star
    //stars 中读取的值都会当成Number读取 而不是Int
    println("---------------------------------")
    val star3: Star2<Int> = Star2<Number>()
    star3.setValue(3)

    val star4: Star2<*> = star3
    //编译不通过
    //star4.setValue(3)
    println("---------------------------------")
    val star5: Star3<String> = Star3<String>("hello")
    val star6: Star3<*> = star5
    star6.getValue()
    //编译不通过
    //star6.setValue("aa")
    println("---------------------------------")
    val list: MutableList<*> = mutableListOf("hello", "world", "hello world")
    println(list[0])
    //编译不通过
    //list[0] = "test"
}