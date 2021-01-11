package com.shengsiyuan._12_exception

import java.lang.NumberFormatException
import javax.xml.bind.DatatypeConverter.parseInt

// 异常 kotlin中的try是个表达式
//Kotlin中是没有checked exception（编译时异常 即throw操作）
// 只有运行时异常（unchecked exception）
fun main() {
    val s = "3"
    val result = try {
        parseInt(s)
    } catch (ex: NumberFormatException) {
        null
    } finally {
        println("finally invoked")
    }
    println(result)
}