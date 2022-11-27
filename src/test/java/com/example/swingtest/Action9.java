package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2414:12
 */
public class Action9 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action9() {
        // TODO Auto-generated constructor stub
        setTitle("文本输入框");
        setSize(600, 300);
        JPanel jp = new JPanel();    //创建一个JPanel对象
        JTextArea jta = new JTextArea("请输入内容", 7, 30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        jta.setBackground(Color.YELLOW);    //设置按钮背景色
        JScrollPane jsp = new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size = jta.getPreferredSize();    //获得文本域的首选大小
        jsp.setBounds(110, 90, size.width, size.height);
        jp.add(jta);    //将JScrollPane添加到JPanel容器中
        add(jp);    //将JPanel容器添加到JFrame容器中
        setBackground(Color.pink);
        setSize(400, 200);    //设置JFrame容器的大小
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action9();
    }
}
