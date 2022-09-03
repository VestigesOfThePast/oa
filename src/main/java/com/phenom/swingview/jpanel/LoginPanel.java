package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.UIConstant;
import com.phenom.swingview.window.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 二维码模块
 * @author olic
 * @date 2022/8/2914:30
 */
public class LoginPanel extends JPanel {

    public LoginPanel(JFrame jFrame){
        init();
        addComponent(jFrame);
    }

    public void init(){
        setBackground(UIConstant.COLOR_ONE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    public void addComponent(JFrame jFrame){
        add(getUpPanel(), BorderLayout.NORTH);
        add(getCenterPanel(jFrame), BorderLayout.CENTER);
        add(getDownPanel(), BorderLayout.SOUTH);
    }

    /**
     * 上部面板
     * @return
     */
    public JPanel getUpPanel(){
        JPanel panelUp = new JPanel();
        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        JLabel jLabelImg = new JLabel();
        Icon icon = new ImageIcon(UIConstant.LOGIN_PANEL_LOGO_TIPS);
        jLabelImg.setIcon(icon);
        JLabel labelUpTip = new JLabel(UIConstant.LOGIN_PANEL_UP_TIPS);
        labelUpTip.setFont(new Font("楷体", Font.PLAIN, 15));
        panelUp.add(jLabelImg);
        panelUp.add(labelUpTip);
        return panelUp;
    }

    /**
     * 中间面板
     * @return
     */
    public JPanel getCenterPanel(JFrame jFrame){
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 2));
        JButton jButton = new JButton("弹出主页面");
        jButton.setSize(100,100);
        //动作监听
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                jFrame.dispose();
            }
        });
        panelCenter.add(jButton);
        return panelCenter;
    }

    /**
     * 底部面板
     * @return
     */
    public JPanel getDownPanel(){
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        JLabel labelDownTip = new JLabel(UIConstant.LOGIN_PANEL_DOWN_TIPS);
        labelDownTip.setFont(new Font("楷体", Font.PLAIN, 15));
        panelDown.add(labelDownTip);
        return panelDown;
    }
}
