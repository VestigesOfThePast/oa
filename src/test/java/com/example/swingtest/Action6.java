package com.example.swingtest;

import javax.swing.*;

/**
 * @author olic
 * @date 2022/8/2413:58
 */
public class Action6 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action6() {
        // TODO Auto-generated constructor stub
        setTitle("测试");
//        setSize(400, 200);
        JPanel jp = new JPanel();    //创建面板
        JLabel label1 = new JLabel("1、普通标签");    //创建标签
        JLabel label2 = new JLabel();
        label2.setText("2、调用setText()方法");
        //创建既含有文本又含有图标的JLabel对象
        jp.add(label1);//添加标签到面板
        jp.add(label2);
        add(jp);
        setBounds(300, 200, 400, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action6();
    }
}
