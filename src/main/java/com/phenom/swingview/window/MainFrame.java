package com.phenom.swingview.window;

import com.phenom.swingview.constant.ExeConstant;
import com.phenom.swingview.eventlistener.ExeListener;
import com.phenom.swingview.jpanel.ExeInfoPanel;
import com.phenom.swingview.jpanel.HostInfoPanel;
import javax.swing.*;
import java.awt.*;

/**
 * RPA执行器-主窗体
 * @author olic
 * @date 2022/8/2814:26
 */
public class MainFrame extends JFrame {

    public MainFrame(){
        init();
        addComponent();
        //设置窗体是否可见。注：需要在加载所有组件之后调用该方法，才可以正常显示组件
        setVisible(true);
        //窗体关闭监听
        ExeListener.closeConfirm(this);
    }

    /**
     * 初始化容器
     */
    public void init(){
        setTitle(ExeConstant.MAIN_WINDOW_TITLE);
        //设置窗体禁止调整大小
        setResizable(false);
        //设置主窗体位置、大小
        setBounds(ExeConstant.getMainWindowX(), ExeConstant.getMainWindowY(), ExeConstant.MAIN_WINDOW_WIDTH,
                ExeConstant.MAIN_WINDOW_HEIGHT);
        //无任何操作(不隐藏窗体也不停止程序)
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    /**
     * 添加组件
     */
    public void addComponent(){
        Container c = getContentPane();
        c.setBackground(ExeConstant.COLOR_TWO);
        c.setLayout(new BorderLayout());
        c.add(new ExeInfoPanel(this), BorderLayout.WEST);
        //默认加载主机信息panel
        c.add(new HostInfoPanel(), BorderLayout.CENTER);
    }

}
