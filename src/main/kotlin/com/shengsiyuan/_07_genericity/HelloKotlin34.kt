package com.shengsiyuan._07_genericity

//泛型擦除
class MyStorage<out T>(private var t: T) {
    fun getValue(): T {
        return t;
    }

    //协变类型不能放在参数位置 除非使用 @UnsafeVariance 注解
    fun setValue(t: @UnsafeVariance T) {
        this.t = t
    }
}

fun main() {
    var myStorage: MyStorage<Int> = MyStorage(5)
    val myStorage2: MyStorage<Any> = myStorage
    println(myStorage2.getValue())

    //加了 @UnsafeVariance
    //泛型擦除
    //在一个类中声明了一个泛型为具体的某个类型（比如Int）
    // 但是字节码层面这些信息是不存在的，字节码里面统一都是Object
    // 在取出的时候被当作 myStorage2 声明的 Any 再做的类型转换
    myStorage2.setValue("hello")
    println(myStorage2.getValue())
}