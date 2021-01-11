package com.shengsiyuan._02_differjava

fun main() {
    var x = 10
    var y = 20
    var max: Int
    var min: Int
    if (x > y) {
        max = x
        min = y
    } else {
        max = y
        min = x
    }


    max = if (x > y) x else y
    min = if (x > y) y else x


    max = if (x > y) {
        println()
        x// {}代码块最后一个表达式默认为返回值
    } else {
        y
    }
    min = if (x > y) {
        y
    } else {
        x
    }
}

fun convert2Int(string: String): Int? {//加问号表示返回值可空
//    try {
//        return string.toInt()
//    } catch (ex: NumberFormatException) {
//        return null
//    }

    return try {
        string.toInt()
    } catch (ex: NumberFormatException) {
        null
    }
}

fun printMultiPly(a: String, b: String) {
    val a2Int: Int? = convert2Int(a)
    val b2Int: Int? = convert2Int(b)
//    if (a2Int == null) {
//        println("a2Int == null")
//    } else if (b2Int == null) {
//        println("b2Int == null")
//    } else {
//        println(a2Int * b2Int)
//    }

    when {
        a2Int == null -> {
            println("a2Int == null")
        }
        b2Int == null -> {
            println("b2Int == null")
        }
        else -> {
            println(a2Int * b2Int)
        }
    }
}