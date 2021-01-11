package com.shengsiyuan._03_class

//Kotlin的类默认都是final类型不可继承的 需要显示的标志为 open
open class Parent(name: String, age: Int) {

}
//Parent(name, age) 这是父类的某个构造方法
class Child(name: String, age: Int) : Parent(name, age) {

}

open class Parent2(name: String) {

}

//子类型没有构造方法的时候 需要在每个二级构造方法后面直接或者间接的调用super来初始化父类
class Child2 : Parent2 {
    constructor(name: String, age: Int) : super(name) {

    }
}