package com.shengsiyuan._13_annotation

import kotlin.reflect.KClass

// 注解也可以拥有自己的构造方法，并且构造方法也可以接受参数
/*
    注解构造方法所允许的参数类型：

    1.与Java原生类型所对应的类型（Int,Long Boolean...）
    2.字符串：string
    3.classes （MyClass::class）
    4.枚举：enums
    5.其他的注解
    6.上述类型的数组类型

    Kotlin的注解参数是不允许为可空类型的，因为JVM不支持以null的形式存储注解属性值的

    如果某个注解被用作其他注解的参数，那么其名字不需要以@字符开头
 */
annotation class MyAnnotation2(val str: String)
annotation class MyAnnotation3(val str: String, val myAnnotation: MyAnnotation2)


@MyAnnotation2("hello")
class MyClass4

@MyAnnotation3("hello", MyAnnotation2("world"))
class MyClass5

/*
    如果需要将某个class作为注解的参数，那么请使用Kotlin class (KClass)
    Kotlin编译器会自动将它转换成Java Class
    这样java代码就可以正常看到注解与参数了
 */


annotation class MyAnnotation4(val arg1: KClass<*>, val arg2: KClass<out Any>)

@MyAnnotation4(String::class, Int::class)
class MyClass6

// 注解的使用处目标
/*
    在对雷的属性或是主构造方法的参数声明注解时，会出现多个Java元素都可以通过对应的Kotlin元素生成出来
    因此在所生成的Java字节码中，就会存在多个可能得位置来生成相应的注解，若想精确指定如何来生成注解，
    那么可以使用注解的使用处目标方式来实现

    //@field @get  @param 使用出目标，明确指定MyAnnotation修饰的是啥
 */


class MyClass7(
    @field: MyAnnotation val arg1: String,
    @get :MyAnnotation val arg2: String,
    @param:MyAnnotation val arg3: String
)