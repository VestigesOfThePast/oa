//package com.example.demo2.jpanels;
//
//import com.example.demo2.constants.UIConstant;
//
//import javax.swing.*;
//import java.awt.*;
//
///**
// * @author olic
// * @date 2022/8/2821:07
// */
//public class MainPanel extends JPanel {
//    public MainPanel(JFrame jFrame){
//        init();
//        addComponent(jFrame);
//    }
//
//    public void init(){
//        setBackground(UIConstant.COLOR_ONE);
//        setBorder(BorderFactory.createLineBorder(UIConstant.COLOR_TWO, 10));
//        setLayout(new BorderLayout());
//    }
//
//    /**
//     * 添加组件
//     */
//    public void addComponent(JFrame jFrame){
//        add(new TaskListPanel(jFrame), BorderLayout.CENTER);
//        add(new ControlPanel(), BorderLayout.SOUTH);
//    }
//}
