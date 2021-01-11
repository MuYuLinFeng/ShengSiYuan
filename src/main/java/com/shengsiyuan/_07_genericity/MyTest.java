package com.shengsiyuan._07_genericity;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        //报错代码
//        List<Object> list2 = list;
//        list2.add(3);
//        String str = list2.get(0);
        /*--------------PECS Producer Extends，Consumer Super------------*/
        List<Cat> cats = new ArrayList<Cat>();
        //放入Animal或者Animal的子类 协变
        List<? extends Animal> animals = cats;

        //不能写入 因为并不能知道animals列表具体的是List<Cat>还是List<Dog>只能知道是Animal或者其子类的List
        //animals.add(new Cat());


        List<Animal> animals1 = new ArrayList<>();
        //放入Animal或者Animal父类 写入的时候 父类转子类所以可以写入
        List<? super Animal> contravariant = animals1;
        contravariant.add(new Animal());
        contravariant.add(new Cat());//多态
        contravariant.add(new Dog());//多态
        //contravariant.add(new Object());//实际类型是Animal

        //这样可行
        List<Object> list = new ArrayList<>();
        list.add(new Object());
        List<? super Animal> contravariant1 = list;
        //contravariant1.add(new Object());

        //不能读取 只能知道是Animal的父类 不知道是Object 还是其他的 父类转子类是错误的
        //Animal animal = contravariant.get(0);

        /*-----------------------------------------*/
        //类型是Object 指向String数组
        Object[] objs = new String[]{"aaa", "bbb"}; //协变
        //这一句引起运行失败
        objs[0] = new Object();//错误做法把String元素改成了Object对象
    }
}

class Animal {

}

class Cat extends Animal {

}

class Dog extends Animal {

}
