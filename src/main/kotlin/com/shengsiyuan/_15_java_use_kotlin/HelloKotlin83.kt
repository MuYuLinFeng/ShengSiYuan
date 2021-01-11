package com.shengsiyuan._15_java_use_kotlin

class People {
    //编译器会生成一个名字叫做Companion的静态内部类
    //定义在companion中的方法和成员隶属于Companion类
    //People顶层类将不会持有这些方法和成员
    companion object {
        var name = "zhangsan"

        /*
            JvmField 修饰对象的作用
            把属性变成public
            把属性的归属变成了People
            所以不需要Companion来访问 直接使用People
         */
        @JvmField
        var age = 10
    }
}