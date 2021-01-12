package com.shengsiyuan._18_coroutine._1_create

fun main() {
    test(5, action = {
        println("hello world")
    })
    test2(5, action = { int ->
        println("hello world $int")
    })

    test(5, ::test3)
    test2(5, ::test4)
    test5(5, ::test6)

    //注意和上面test2调用的差别
    //当最后一个参数只接受一个参数的时候（test2），参数名可以隐藏的it
    //如果是两个则必须显示写出（test5）。
    test5(5, action = { _, _ ->
        println("a")
    })

}

fun test(x: Int, action: () -> Unit) {
    action()
}

fun test2(x: Int, action: (Int) -> Unit) {
    action(100)
}

fun test3() {

}

fun test4(x: Int) {

}

fun test5(x: Int, action: (Int, Int) -> Unit) {
    action(1, 2)
}

fun test6(x: Int, y: Int) {
    println(x + y)
}