package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2411:06
 */
public class Action1 extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action1() {
        // TODO Auto-generated constructor stub
        setTitle("面板测试");
        //设置窗口位置和大小·前面俩是x y轴,后面俩是长高
        setBounds(600, 300, 1200, 200);
        //创建一个面板对象
        JPanel jp = new JPanel();
        //创建一个文本标签
        JLabel jl = new JLabel("祝愿程序员都会开心幸福安康。");
        jl.setFont(new Font("黑体", Font.BOLD, 66));
        /**
         *1、边框布局（BorderLayout）
         *2、流式布局（FlowLayout）
         *3、网格布局（GridLayout）
         *4、盒子布局（BoxLaYout）
         *5、空布局（null）
         */
        jl.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp.setBackground(Color.pink);//设置背景色·喜欢粉色
        jp.add(jl);//将标签添加到面板
        add(jp);//将面板添加到窗口
        setVisible(true);//设置窗口可见
        setDefaultCloseOperation(EXIT_ON_CLOSE);//别忘关闭窗口
    }

    public static void main(String[] args) {
        new Action1();
    }
}
