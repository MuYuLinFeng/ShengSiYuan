package com.shengsiyuan._08_innerclass

class OuterClass5 {
    inner class InnerClass5(str: String) {
        init {
            println(str)
        }
    }
}

fun main() {
    var innerClass5: OuterClass5.InnerClass5 = OuterClass5().InnerClass5("hello world");

}