package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2411:17
 */
public class Action3 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action3() {
        // TODO Auto-generated constructor stub
        setTitle("流式布局");
//        setSize(400, 200);
        JPanel jPanel = new JPanel();//创建面板
        JButton btn1 = new JButton("1");//创建按钮
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        //按钮背景色
        btn7.setBackground(Color.BLUE);
        //按钮文字颜色
        btn7.setForeground(Color.WHITE);
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        jPanel.add(btn1);//面板中添加按钮
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        jPanel.setBackground(Color.pink);    //设置背景色
        add(jPanel);    //添加面板到容器
        setBounds(300, 200, 300, 150);    //设置容器的大小
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action3();
    }
}
