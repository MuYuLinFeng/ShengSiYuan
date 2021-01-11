package com.shengsiyuan._16_java_use_kotlin

import java.io.FileNotFoundException
import kotlin.Throws

/*
    Kotlin中不存在checked exception
 */
class MyClass3 {
    /*
        使Java认识此方法有throw一个exception
     */
    @Throws(FileNotFoundException::class)
    fun method() {
        println("method invoked")
        throw FileNotFoundException()
    }
}