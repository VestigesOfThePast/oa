package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2414:20
 */
public class Action11 extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action11() {
        // TODO Auto-generated constructor stub
        setTitle("文本输入框");
        setSize(800, 100);
        JPanel jp = new JPanel();    //创建面板
        JLabel label = new JLabel("嵩山秘术·初子决：");
        label.setFont(new Font("华文行楷", Font.BOLD, 26));    //修改字体样式
        JCheckBox chkbox1 = new JCheckBox("拙石", true);    //创建指定文本和状态的复选框
        JCheckBox chkbox2 = new JCheckBox("璞玉");    //创建指定文本的复选框
        JCheckBox chkbox3 = new JCheckBox("破梦", true);
        JCheckBox chkbox4 = new JCheckBox("灭神");
        JCheckBox chkbox5 = new JCheckBox("诸佛", true);
        JCheckBox chkbox6 = new JCheckBox("戳魔");
        jp.add(label);
        jp.add(chkbox1);
        jp.add(chkbox2);
        jp.add(chkbox3);
        jp.add(chkbox4);
        jp.add(chkbox5);
        jp.add(chkbox6);
        add(jp);
        setBackground(Color.pink);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Action11();
    }
}
