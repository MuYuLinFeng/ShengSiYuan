package com.shengsiyuan._15_java_use_kotlin

/*
    属性 （property）
    每一个Kotlin的属性会被编译成三部分Java元素
     1.get
     2.set
     3.私有的field字段，名字与Kotlin属性名一样

    如果Kotlin属性名以is开头 那么命名约定会发生一些变化：
     1.getter 方法名与属性名一样
     2.setter 方法则是将is替换为set
     这种规则适用于任何类型而不单单是Boolean类型
 */

class Test {
    var name: String = "张三"
    var isStudent: String = "yes"
}