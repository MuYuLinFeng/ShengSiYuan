package com.shengsiyuan._06_dataclass

//数据类 data class

data class Person(val name: String, var age: Int, var address: String)

/*
    主构造方法至少要有一个参数
    所有的主构造方法都需要被标记为val或者var 标记了叫属性 不标记叫参数
    数据类不能是抽象 open sealed（密封）inner类

    编译器会自动生成：
    equals hashCode
    toString 方法 Person(name=zhangsan, age=20, address=beijing)
    针对属性的 componentN 方法，并且按照属性的声明顺序来生成
    copy方法
    getter setter


    关于数据类的继承要点
    1、如果数据类中显示定义了equal hashCode toString方法或者是再数据类的父类中将这些方法声明为了final
        那么这些方法不会再生成，会使用现成的
    2、如果父类拥有了 componentN 方法并且是open的 返回类型是兼容的类型 那么编译器就会在数据类中生成相应的 componentN方法
        并且重写父类中的这些方法，如果父类中的这些方法由于不兼容的签名或是被定义为final的 那么编译器就会报错
    3、在数据类中显式提供 componentN 方法一级copy方法是不允许的

    解构声明 componentN
    1、在主构造方法中有多少参数就会生成多少个对应的 componentN 方法
        这些方法返回对应的数值 主要是用来解构使用
 */
fun main() {
    var person = Person("zhangsan", 20, "beijing")
    println(person)
    println(person.name)
    println(person.copy(age = 55))
    println("---------------")
    var (name, age, address) = person //解构写法 必须按顺序 不缺漏 不然数据对应错误

    println("$name $age $address")
}

//所有成员有默认值的情况下 编译器提供无参构造方法
data class Person2(val name: String = "", var age: Int = 20, var address: String = "tianjin")