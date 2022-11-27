package com.example.swingtest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author olic
 * @date 2022/8/2414:52
 */
public class Action15 extends JFrame {
    JList list;
    JLabel label;
    JButton button1;
    int clicks = 0;

    public Action15() {
        setTitle("动作事件监听器示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 300, 400, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        label = new JLabel("还未点击过");
        label.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        contentPane.add(label, BorderLayout.SOUTH);
        button1 = new JButton("我是普通按钮");    //创建JButton对象
        button1.setFont(new Font("黑体", Font.BOLD, 16));    //修改字体样式
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("按钮被单击了 " + (clicks++) + " 次");
            }
        });
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e1) {
//                        // TODO Auto-generated catch block
//                        e1.printStackTrace();
//                    }
//                    label.setText("自动点击了1次，当前 " + (clicks++) + " 次");
//                }
//            }
//        }).start();
        contentPane.add(button1);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Action15();
    }
}