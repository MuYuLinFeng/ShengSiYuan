package com.shengsiyuan._07_genericity

import org.junit.Assert.assertTrue

//在Kotlin中 Consumer 用 in  ，Producer 用 out
class ParameterizedClass<A>(private val value: A) {
    fun getValue(): A {
        return this.value
    }
}

class ParameterizedProducer<out T>(private val value: T) {
    fun get(): T {
        return this.value
    }
}

class ParameterizedConsumer<in T> {
    fun set(t: T) {
        println(t.toString())
    }
}

fun main() {
    val parameterizedClass = ParameterizedClass<String>("hello world")
    val result = parameterizedClass.getValue()

    assertTrue(result is String)

    val parameterizedProducer = ParameterizedProducer("welcome")
    val myRef: ParameterizedProducer<Any> = parameterizedProducer
    //协变
    // List<String> list2 = new ArrayList();
    //List<? extends Object> list = list2;
    assertTrue(myRef is ParameterizedProducer<Any>)

    val parameterizedConsumer = ParameterizedConsumer<Number>()
    val myRef2: ParameterizedConsumer<Int> = parameterizedConsumer
    //逆变
    //List<Object> list = new ArrayList();
    //List<? super String> list2 = list;
    assertTrue(myRef2 is ParameterizedConsumer<Int>)

    parameterizedConsumer.set(1)
}