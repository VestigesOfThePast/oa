package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.ExeConstant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 执行器信息模块
 * @author olic
 * @date 2022/8/2818:53
 */
public class ExeInfoPanel extends JPanel {
    JButton hButton, tlButton, cButton;

    public ExeInfoPanel(JFrame jFrame){
        init();
        addComponent(jFrame);
    }

    public void init(){
        //设置边界模式下指定区域的大小
        setPreferredSize(new Dimension(150, 150));
        setBackground(ExeConstant.COLOR_THREE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent(JFrame jFrame) {
        add(getUpPanel(),BorderLayout.NORTH);
        add(getCenterPanel(jFrame), BorderLayout.CENTER);
    }

    /**
     * 上部面板
     * @return
     */
    public JPanel getUpPanel(){
        JPanel panelUp = new JPanel();
        panelUp.setPreferredSize(new Dimension(150, 100));
        panelUp.setBackground(ExeConstant.COLOR_THREE);
        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
        JLabel jLabelImg = new JLabel();
        Icon icon = new ImageIcon(ExeConstant.EXE_INFO_PANEL_LOGO_IMG);
        //添加图片。即使设置标签大小也不会改变图片大小
        jLabelImg.setIcon(icon);
        JLabel labelTip = new JLabel(ExeConstant.EXE_INFO_PANEL_LOGO_TITLE);
        labelTip.setFont(new Font("行楷", Font.PLAIN, 15));
        panelUp.add(jLabelImg);
        panelUp.add(labelTip);
        return panelUp;
    }

    /**
     * 中间面板
     * @return
     */
    public JPanel getCenterPanel(JFrame jFrame){
        JPanel panelDown = new JPanel();
        panelDown.setBackground(ExeConstant.COLOR_THREE);
        panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 35));
        //主机信息
        hButton = new JButton(ExeConstant.MenuEnum.HOST_INFO.getName());
        addButton(hButton, panelDown, jFrame);
        //任务列表
        tlButton = new JButton(ExeConstant.MenuEnum.TASK_LIST.getName());
        addButton(tlButton, panelDown, jFrame);
        //控制台
        cButton = new JButton(ExeConstant.MenuEnum.CONTROL.getName());
        addButton(cButton, panelDown, jFrame);
        return panelDown;
    }

    /**
     * 添加按钮
     */
    public void addButton(JButton jButton, JPanel panelDown, JFrame jFrame){
        //设置按钮背景色
        if(ExeConstant.MenuEnum.HOST_INFO.getName().equals(jButton.getText())){
            setButtonStyle(jButton, ExeConstant.COLOR_FIVE);
        }else {
            setButtonStyle(jButton, ExeConstant.COLOR_SIX);
        }
        switchCenterPanel(jButton, jFrame);
        panelDown.add(jButton);
    }

    /**
     * 按钮监听，根据选择的页签加载不同的Jpanel
     */
    public void switchCenterPanel(JButton button, JFrame jFrame){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container contentPane = jFrame.getContentPane();
                //移除容器里右侧的panel
                contentPane.remove(1);
                //设置按钮背景色
                setButtonStyle(button, ExeConstant.COLOR_FIVE);
                switch (button.getText()) {
                    case ExeConstant.TASK_LIST_PANEL_TITLE:
                        setButtonStyle(hButton, ExeConstant.COLOR_SIX);
                        setButtonStyle(cButton, ExeConstant.COLOR_SIX);
                        contentPane.add(new TaskListPanel(jFrame), BorderLayout.CENTER);
                        break;
                    case ExeConstant.CONSOLE_PANEL_TITLE:
                        setButtonStyle(hButton, ExeConstant.COLOR_SIX);
                        setButtonStyle(tlButton, ExeConstant.COLOR_SIX);
                        contentPane.add(new ConsolePanel(), BorderLayout.CENTER);
                        break;
                    case ExeConstant.EXE_INFO_WINDOW_TITLE:
                        setButtonStyle(cButton, ExeConstant.COLOR_SIX);
                        setButtonStyle(tlButton, ExeConstant.COLOR_SIX);
                        contentPane.add(new HostInfoPanel(), BorderLayout.CENTER);
                }
                jFrame.setVisible(true);
            }
        });
    }

    /**
     * 设置按钮样式
     */
    public void setButtonStyle(JButton button, Color color){
        //设置文本字体
        button.setFont(new Font("华文行楷", Font.PLAIN, 15));
        //设置文本颜色
        button.setForeground(ExeConstant.COLOR_ONE);
        //设置按钮大小
        Dimension preferredSize = new Dimension(120,30);
        button.setPreferredSize(preferredSize);
        //设置按钮背景颜色
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

}
