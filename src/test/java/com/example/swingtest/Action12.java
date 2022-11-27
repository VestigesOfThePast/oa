package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2414:24
 */
public class Action12 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action12() {
        // TODO Auto-generated constructor stub
        setTitle("文本输入框");
        setSize(800, 100);
        JPanel jp = new JPanel();    //创建面板
        JLabel label1 = new JLabel("幸福模式：");    //创建标签
        JComboBox cmb = new JComboBox();    //创建JComboBox
        cmb.addItem("--请选择--");    //向下拉列表中添加一项
        cmb.addItem("长命百岁");
        cmb.addItem("幸福安康");
        cmb.addItem("颐养天年");
        jp.add(label1);
        jp.add(cmb);
        add(jp);
        setBackground(Color.pink);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action12();
    }
}
