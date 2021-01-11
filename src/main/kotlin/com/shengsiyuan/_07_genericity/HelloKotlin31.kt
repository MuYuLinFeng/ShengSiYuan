package com.shengsiyuan._07_genericity

/*
    Kotlin在声明处协变 java在使用处协变

    Kotlin中的out关键字叫做 variance annotation（变量注解），
    因为他是在类型参数声明处所指定的，因此我们称之为声明处协变（declaration-site variance）

    对于Java来说则是使用处协变（use-site variance），其中类型通配符使得类型协变成为可能

    class B<T extends CharSequence> //这个不是Java的使用处协变
    B<T extends CharSequence> //使用处协变
*/

interface Producer<out T> {
    //T是协变类型 只能用作返回类型
    fun produce(): T
}

interface Consumer<in T> {
    //T是逆变类型 只能用作输入参数
    fun consumer(t: T)
}

interface ProducerConsumer<T> {
    //不可能有一个泛型参数 既能作为返回值又能作为参数
    //T只能是其本身
    fun product(): T
    fun consumer(t: T)
}

open class Fruit
open class Apple : Fruit()
class ApplePear : Apple()

class FruitProducer : Producer<Fruit> {
    override fun produce(): Fruit {
        println("Producer Fruit")
        return Fruit();
    }
}

class AppleProducer : Producer<Apple> {
    override fun produce(): Apple {
        println("Producer Apple")
        return Apple();
    }
}

class ApplePearProducer : Producer<ApplePear> {
    override fun produce(): ApplePear {
        println("Producer ApplePear")
        return ApplePear();
    }
}

fun producer() {
    val producer1: Producer<Fruit> = FruitProducer()
    producer1.produce()
    val producer2: Producer<Fruit> = AppleProducer() //赋值Fruit的直接子类
    producer2.produce() //实际指向的是AppleProducer，实例执行输出Producer Apple
    val producer3: Producer<Fruit> = ApplePearProducer() //赋值Fruit的间接子类
    producer3.produce()
    /*
        val producer4: Producer<ApplePear> = AppleProducer();
        这一行是错的因为声明的返回类型是Producer<ApplePear> 真正运行的时候指向AppleProducer
        也就是声明需要的是ApplePear 结果返回了Apple是不行的 因为Apple是父类型可能有别的子类型
        声明者看到的是父类型 具体执行的时候是其子类型
    */
}

class Human : Consumer<Fruit> {
    override fun consumer(t: Fruit) {
        println("Consume Fruit")
    }
}

class Man : Consumer<Apple> {
    //多态 体现在这里
    // 声明类型为 ApplePear 实际实例的参数类型为 Apple 将ApplePear赋值给Apple 当然是可以
    // 声明类型要小于赋值类型
    override fun consumer(t: Apple) {
        println("Consume Apple")
    }
}

class Boy : Consumer<ApplePear> {
    override fun consumer(t: ApplePear) {
        println("Consume ApplePear")
    }
}

fun customer() {
    val customer1: Consumer<ApplePear> = Human()
    customer1.consumer(ApplePear())
    val customer2: Consumer<ApplePear> = Man()
    customer2.consumer(ApplePear())
    val customer3: Consumer<ApplePear> = Boy()
    customer3.consumer(ApplePear())
    /*
        val customer4: Consumer<Fruit> = Boy()
        错误示范
        编译期的时候定义为 Fruit 则 consumer 方法只能传入 Fruit 类型
        而运行期为Boy() 只能传入 ApplePear 或者其子类型
        当传入 Fruit 的时候则变成了将 Fruit 赋给 ApplePear 违反了多态原则
    */
}

fun main() {
    producer()
    println("======================")
    customer()
}