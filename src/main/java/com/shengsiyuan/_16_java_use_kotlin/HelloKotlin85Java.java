package com.shengsiyuan._16_java_use_kotlin;

import java.util.ArrayList;
import java.util.List;

public class HelloKotlin85Java {
    public static void main(String[] args) {
        List<String> stringList = HelloKotlin85Kt.myFilter(new ArrayList<>());
        System.out.println(stringList);
        List<Integer> integerList = HelloKotlin85Kt.myFilterJava(new ArrayList<>());
        System.out.println(integerList);
    }
}
