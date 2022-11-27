package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2414:06
 */
public class Action8 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action8() {
        // TODO Auto-generated constructor stub
        setTitle("文本输入框");
        setSize(600, 300);
        JPanel jp = new JPanel();    //创建面板
        JTextField txtfield1 = new JTextField();    //创建文本框
        txtfield1.setText("普通文本框");    //设置文本框的内容
        txtfield1.scrollRectToVisible(new Rectangle(20,10,5,5));
        JTextField txtfield2 = new JTextField(28);
        txtfield2.setFont(new Font("楷体", Font.BOLD, 16));    //修改字体样式
        txtfield2.setText("指定长度和字体的文本框");
        JTextField txtfield3 = new JTextField(30);
        txtfield3.setText("居中对齐");
        txtfield3.setHorizontalAlignment(JTextField.CENTER);    //居中对齐
        jp.add(txtfield1);
        jp.add(txtfield2);
        jp.add(txtfield3);
        add(jp);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action8();
    }
}