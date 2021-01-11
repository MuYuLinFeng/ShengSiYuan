package com.shengsiyuan._05_property

class CompanionObjectExtension {
    companion object MyObject {

    }

}

fun CompanionObjectExtension.MyObject.method() {
    println("hello world")
}

fun main() {
    CompanionObjectExtension.method()
}