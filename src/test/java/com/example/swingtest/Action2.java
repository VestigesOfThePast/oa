package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2411:09
 */
public class Action2 extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action2() {
        // TODO Auto-generated constructor stub
//        setSize(400,200);
        //为Frame窗口设置布局为边框布局:BorderLayout
        setLayout(new BorderLayout());
        JButton button1=new JButton ("上·一般写标题或菜单");
        JButton button2=new JButton("左·写菜单的比较多，但不一定用");
        JButton button3=new JButton("中·表格信息");
        JButton button4=new JButton("右·很少用到");
        JButton button5=new JButton("下·备案号啥的");
        //上n下s左w右e中center
        add(button1,BorderLayout.NORTH);
        add(button2, BorderLayout.WEST);
        add(button3,BorderLayout.CENTER);
        add(button4,BorderLayout.EAST);
        add(button5,BorderLayout.SOUTH);
        setBounds(300,200,600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Action2();
    }
}
