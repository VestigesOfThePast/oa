package com.example.swingtest;

import javax.swing.*;
import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2410:54
 */
public class Action extends JFrame {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    public Action() {
        setTitle("大标题，就是左上角显示的标题"); //设置显示窗体标题
//        setSize(300, 200); //设置窗体显示尺寸，单位：像素
//        setLocation(200,200); //设置窗体位置，单位：像素
        setBounds(200,200,300,200); //设置窗体位置和尺寸
        /**
         * 窗体关闭规则
         * EXIT_ON_CLOSE：隐藏窗体，并停止程序
         * DO_NOTHING_ON_CLOSE：无任何操作(不隐藏窗体也不停止程序)
         * HIDE_ON_CLOSE：隐藏窗体，但并不停止程序
         * DISPOSE_ON_CLOSE：释放窗体资源。会停止程序
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); //获取本窗体容器
        c.setBackground(Color.WHITE); //设置背景颜色
        JLabel lable = new JLabel("lable就是一个文本"); //创建一个标签
        c.add(lable); //将lable标签组件添加到容器中
//        c.remove(lable); //删除lable标签组件
        c.validate(); //使窗体重新载入容器
        setVisible(true); //设置窗体是否可见
        setResizable(false); //设置窗体是否可以改变大小
        System.out.println("x="+getX()+" y="+getY());
    }

    public static void main(String[] args) {
        new Action();
    }
}
