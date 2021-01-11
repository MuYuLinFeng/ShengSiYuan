package com.shengsiyuan._07_genericity;
//package com.shengsiyuan._07_genericity;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class 协变逆变 {
//    public static void main(String[] args) {
//        // 协变（covariant）和逆变（controversial）
//        List<Object>
//        List<String>
//        //List<String> 不是 List<Object>的子类 List不支持协变
//
//        List<String> list = new ArrayList();
//        List<Object> list2 = list; //编译失败
//
//        list2.add (new Date( ) );
//        String str = list.get(0);
//
//        //通配符的出现 解决上面问题
//        List<? extends Object> list ...
//
//
//        interface Collection<E> {
//            void addAll(Collection<E> items)
//        }
//
//        interface Collection<E> {
//            //错误做法
//            void addAll(Collection<E> items)
//
//            //java库 实际上是这样的
//            //可以随意的把集合内容当作E来读取而不当作实际类型来读取
//            // 而不能随意的写入修改内容 ，因为可以添加E的任意子类实例 但是不知道实际类型
//            boolean addAll(Collection<? extends E> c);
//            //Number或其子类
//        }
//
//        void copyAll(Collection<Object> to, Collection<String> from) {
//            to.addAll(from)
//        }
//
//        //被限制了上界 只能读取 读取到的当作E 叫做协变  生产者
//       // Collection<String> 就是Collection<? extends Object>的子类型 而不是Collection<Object>;
//
//        //限定了只能放入String的父类 只能写入成String 是类型安全的 叫做逆变 消费者
//       //List<? super String>
//       //List<? super E>
//
//        List<? super Number> list001 = new ArrayList<Number>();
//        //Object或其他Number的父类
//        list001.add(new Integer(3));
//        list001.add(new Float(2.1));
//
//
//        List<? super Number> list002 = new ArrayList<Object>();
//        list002.add(3);
//        list002.add(1);
//    }
//}
