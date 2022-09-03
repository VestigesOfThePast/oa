package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.UIConstant;
import lombok.extern.slf4j.Slf4j;
import javax.swing.*;
import java.awt.*;

/**
 * 控制台模块
 * @author olic
 * @date 2022/8/2819:41
 */
@Slf4j
public class ConsolePanel extends JPanel {
    public static JTextArea jTextArea = new JTextArea(15, 60);

    public ConsolePanel(){
        init();
        addComponent();
    }

    public void init(){
        setBackground(UIConstant.COLOR_ONE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    public void addComponent(){
//        add(getUpPanel(), BorderLayout.NORTH);
        add(getCenterPanel(), BorderLayout.CENTER);
    }

//    /**
//     * 上部面板
//     * @return
//     */
//    public static JPanel getUpPanel(){
//        JPanel panelUp = new JPanel();
//        panelUp.setBackground(UIConstant.COLOR_FOUR);
//        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
//        JLabel labelTitle = new JLabel(UIConstant.CONTROL_PANEL_TITLE);
//        labelTitle.setFont(new Font("宋体", Font.BOLD, 25));
//        panelUp.add(labelTitle);
//        return panelUp;
//    }

    /**
     * 中部面板
     * @return
     */
    public static JPanel getCenterPanel(){
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1,1));
//        JTextArea jTextArea = new JTextArea(15, 60);
        //每次光标显示到最下面一行
        jTextArea.setCaretPosition(jTextArea.getText().length());
        //激活自动换行功能。根据jTextArea宽度自动换行
        jTextArea.setLineWrap(true);
        //激活断行不断字功能
        jTextArea.setWrapStyleWord(true);
        //设置内容不可编辑
        jTextArea.setEditable(false);
        //设置字体、背景等样式
        jTextArea.setBackground(new Color(0, 0, 0));
        jTextArea.setFont(new Font("华文行楷", Font.PLAIN, 15));
        jTextArea.setForeground(UIConstant.COLOR_NINE);

//        // 子线程开始从流中读取数据
//        Thread thread = new Thread(() -> {
//            String line = null;
//            while (true) {
//                try {
//                    //控制台日志超过1000行刷新
//                    if(jTextArea.getLineCount() > 1000){
//                        jTextArea.setText("");
//                    }
//                    line = RpaExeConsoleAppender.bufferedReader.readLine();
//                    jTextArea.append(line+"\n");
//                } catch (IOException e) {
//                }
//            }
//        });
//        thread.setDaemon(Boolean.TRUE);
//        thread.setName("console-log");
//        thread.start();

        //水平方向不滚动，竖直方向滚动
        JScrollPane areaJP = new JScrollPane(jTextArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(areaJP);
        return panelCenter;
    }
}
