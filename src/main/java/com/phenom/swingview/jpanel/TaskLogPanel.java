package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.ExeConstant;
import javax.swing.*;
import java.awt.*;

/**
 * 任务日志模块
 * @author olic
 * @date 2022/9/420:20
 */
public class TaskLogPanel extends JPanel {

    public TaskLogPanel(){
        init();
        addComponent();
    }

    public void init(){
        setBackground(ExeConstant.COLOR_ONE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    public void addComponent(){
        add(getCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * 中部面板
     * @return
     */
    public static JPanel getCenterPanel(){
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1,1));
        JTextArea jTextArea = new JTextArea(15, 60);
        //每次光标显示到最下面一行
        jTextArea.setCaretPosition(jTextArea.getText().length());
        //激活自动换行功能。根据jTextArea宽度自动换行
        jTextArea.setLineWrap(true);
        //激活断行不断字功能
        jTextArea.setWrapStyleWord(true);
        //设置内容不可编辑
        jTextArea.setEditable(false);
        //设置字体、背景等样式
        jTextArea.setBackground(ExeConstant.COLOR_ONE);
        jTextArea.setFont(new Font("华文行楷", Font.PLAIN, 15));
        jTextArea.setForeground(ExeConstant.COLOR_SIX);

        //水平方向不滚动，竖直方向滚动
        JScrollPane areaJP = new JScrollPane(jTextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(areaJP);
        return panelCenter;
    }
}
