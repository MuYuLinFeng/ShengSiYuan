package com.shengsiyuan._02_differjava

fun main() {
    println(myPrint2("hello"))

    var a = 6
    var result = when (a) {
        1 -> {
            println("a = 1")
            10
        }
        2, 3, 4, 5 -> {
            30
        }
        in 6..10->{
            100
        }
        else -> {
            1000
        }
    }
    println(result)
}

fun myPrint2(str: String) = when (str) {
    "hello" -> {
        "HELLO"
    }
    "world" -> {
        "WORLD"
    }
    "hello world" -> {
        "HELLO WORLD"
    }
    else -> {
        "other input"
    }
}

fun myPrint(str: String): String {
    return when (str) {
        "hello" -> {
            "HELLO"
        }
        "world" -> {
            "WORLD"
        }
        "hello world" -> {
            "HELLO WORLD"
        }
        else -> {
            "other input"
        }
    }
//    when (str) {
//        "hello" -> {
//            return "HELLO"
//        }
//        "world" -> {
//            return "WORLD"
//        }
//        "hello world" -> {
//            return "HELLO WORLD"
//        }
//        else -> {
//            return "other input"
//        }
//    }
}