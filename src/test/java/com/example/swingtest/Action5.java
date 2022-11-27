package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2413:54
 */
public class Action5 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action5() {
        // TODO Auto-generated constructor stub
        setTitle("网格布局");
//        setSize(400, 200);
        JPanel panel = new JPanel();//创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为10
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        Font font = new Font("黑体", Font.BOLD, 50);
        panel.add(new JButton("7"));//添加按钮
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        JButton butResult = new JButton("=");
        butResult.setFont(font);
        panel.add(butResult);
        panel.add(new JButton("+"));
        add(panel);    //添加面板到容器
        setBounds(300, 200, 666, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action5();
    }
}
