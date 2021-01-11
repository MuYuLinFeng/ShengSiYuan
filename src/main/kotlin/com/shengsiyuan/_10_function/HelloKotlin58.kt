package com.shengsiyuan._10_function

fun main() {
    println("hfdjsi4343hj5t45htj4ik5t4".filterString(checkIsDigit))
    println("hfdjsi4343hj5t45htj4ik5t4".filterString(checkIsChar))
}

val checkIsDigit: (Char) -> Boolean = { char: Char -> char.isDigit() }
val checkIsChar: (Char) -> Boolean = { char: Char -> char.isLetter() }

fun String.filterString(predicate: (Char) -> Boolean): String {
    var result = ""
    this.map {
        if (predicate(it)) {
            result += it
        }
    }
    return result
}
