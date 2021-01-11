package com.shengsiyuan._08_innerclass

import java.awt.event.ActionListener
import java.awt.event.WindowEvent
import java.awt.event.WindowListener
import javax.swing.JButton
import javax.swing.JFrame

fun main() {
    val jFrame = JFrame("My JFrame")
    val jButton = JButton("My JButton")
    jFrame.addWindowListener(object : WindowListener {
        override fun windowDeiconified(e: WindowEvent?) {
            println("window deiconified")
        }

        override fun windowClosing(e: WindowEvent?) {
            println("window closing")
        }

        override fun windowClosed(e: WindowEvent?) {
            println("window closed")
        }

        override fun windowActivated(e: WindowEvent?) {
            println("window active")
        }

        override fun windowDeactivated(e: WindowEvent?) {
            println("window deactivated")
        }

        override fun windowOpened(e: WindowEvent?) {
            println("window opened")
        }

        override fun windowIconified(e: WindowEvent?) {
            println("window iconified")
        }

    })
    jButton.addActionListener {
        println("button click")
    }


    val listener = ActionListener {
        println("hello world")
    }
    println(listener.javaClass)
    println(listener.javaClass.superclass)
    println(listener::class.java)
    println(listener::class.java.superclass)

    jFrame.add(jButton)
    jFrame.pack();
    jFrame.isVisible = true;
    jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE;
}