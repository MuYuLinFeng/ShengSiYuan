package com.shengsiyuan._11_collection

/*
    Array List Map

    Kotlin严格区分可变集合和不可变集合

    要清楚的一点是：区分开(可变集合的只读视图)与实际上真正的(不可变集合)
*/
fun main() {
    val stringList: MutableList<String> = mutableListOf("hello", "world", "hello world")
    val readOnlyView: List<String> = stringList

    println(stringList)
    stringList.add("welcome")
    println(readOnlyView)

//    readOnlyView.clear()


    val strings: HashSet<String> = hashSetOf("a", "b", "c", "c")
    println(strings.size)
    //只读类型是协变的，因为它只用于从集合中获取数据，而不会修改集合中的数据
    //协变 可以把子类型赋给父类型
    val s = listOf("a", "b")
    val s2: List<Any> = s

    //快照 把值深度复制 保留一个不可变的副本
    val items = mutableListOf("a", "b", "c")
    val items2 = items.toList()
    items.add("d")
    println(items)
    println(items2)

}