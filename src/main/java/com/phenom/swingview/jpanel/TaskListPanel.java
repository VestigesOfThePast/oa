package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.UIConstant;
import com.phenom.swingview.window.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 任务列表模块
 * @author olic
 * @date 2022/8/2818:30
 */
public class TaskListPanel extends JPanel {
    public TaskListPanel(JFrame jFrame){
        init();
        addComponent(jFrame);
    }

    /**
     * 初始化panel
     */
    private void init() {
        setBackground(UIConstant.COLOR_ONE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent(JFrame jFrame) {
//        add(getUpPanel(), BorderLayout.NORTH);
        add(getCenterPanel(jFrame), BorderLayout.CENTER);
    }

//    /**
//     * 上部面板
//     * @return
//     */
//    public static JPanel getUpPanel() {
//        JPanel panelUp = new JPanel();
//        panelUp.setBackground(UIConstant.COLOR_FOUR);
//        panelUp.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
//        JLabel labelTitle = new JLabel(UIConstant.TASK_LIST_PANEL_TITLE);
//        labelTitle.setFont(new Font("宋体", Font.BOLD, 25));
//        panelUp.add(labelTitle);
//        return panelUp;
//    }

    /**
     * 中部面板
     * @return
     */
    public static JPanel getCenterPanel(JFrame jFrame) {
        // 中间面板
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1,1));
        JList<String> jList = new JList<>();
        jList.setBackground(UIConstant.COLOR_TWO);
        jList.setFixedCellHeight(UIConstant.TASK_LIST_PANEL_ROW_GAP);
        //多选模式
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        String[] itemL = {"任务1","任务2","任务3","任务4","任务5","任务6","任务7","任务8","任务9","任务10"};
        //构建列表框模型
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String s: itemL){
            listModel.addElement(s);
        }
        jList.setModel(listModel);
        //添加鼠标双击事件
        jList.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){	//When double click JList
                    new TaskLogFrame(jFrame);
                }
            }
        });
        JScrollPane listJP = new JScrollPane();
        listJP.setViewportView(jList);
        panelCenter.add(listJP);
        return panelCenter;
    }

}
