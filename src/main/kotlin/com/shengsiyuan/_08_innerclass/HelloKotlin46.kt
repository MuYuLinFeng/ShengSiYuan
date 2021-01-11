package com.shengsiyuan._08_innerclass

import java.awt.event.WindowEvent
import java.awt.event.WindowListener

//对象声明
object MyObject {
    fun method() = "hello world"
}

object MyObject2 : WindowListener {
    override fun windowOpened(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowClosing(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowClosed(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowIconified(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowDeiconified(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowActivated(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

    override fun windowDeactivated(e: WindowEvent?) {
        TODO("Not yet implemented")
    }

}

/*
 关于对象表达式与对象声明的区别：
 1. 对象表达式是立刻初始化或是执行的
 2. 对象声明是延迟初始化的，在首次访问的时候进行
 3.伴生对象在其所对应的类被加载时初始化的，对应于java的静态初始化
 */
fun main() {
    println(MyObject.method())
}