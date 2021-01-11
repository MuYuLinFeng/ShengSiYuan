package com.shengsiyuan._08_innerclass;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class JFrameTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");
        jFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("window opened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("window closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("window active");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        jButton.addActionListener(ee -> {
            System.out.println("button click");
        });
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
