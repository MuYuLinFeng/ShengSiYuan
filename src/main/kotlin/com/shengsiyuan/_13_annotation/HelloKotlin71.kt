package com.shengsiyuan._13_annotation

// 注解 （annotation）
// meta-annotation （元注解）

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.EXPRESSION,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class MyAnnotation

@MyAnnotation
class MyClass {
    @MyAnnotation
    fun myMethod(@MyAnnotation a: Int): Int {
        return (@MyAnnotation 10)
    }
}

class MyClass2 @MyAnnotation constructor(a: Int)//constructor 关键字不可省略

class MyClass3 {
    var a: Int? = null
        @MyAnnotation set
}
