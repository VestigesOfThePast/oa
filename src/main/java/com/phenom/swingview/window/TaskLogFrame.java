package com.phenom.swingview.window;

import com.phenom.swingview.constant.ExeConstant;
import com.phenom.swingview.jpanel.TaskLogPanel;
import javax.swing.*;
import java.awt.*;

/**
 * RPA执行器-任务日志窗体
 * 子窗体使用JDialog，JDialog是弹出窗体
 * @author olic
 * @date 2022/8/3013:33
 */
public class TaskLogFrame extends JDialog {

    public TaskLogFrame(JFrame jFrame){
        //打开子窗体，锁定父窗体，父窗体不可操作
        super(jFrame, "主窗体", true);
        init();
        addComponent();
        //设置窗体是否可见。注：需要在加载所有组件之后调用该方法，才可以正常显示组件
        setVisible(true);
    }

    /**
     * 初始化容器
     */
    public void init(){
        setTitle(ExeConstant.TASK_LOG_WINDOW_TITLE);
        //设置窗体禁止调整大小
        setResizable(false);
        //设置主窗体位置、大小
        setBounds(ExeConstant.getTaskLogWindowX(), ExeConstant.getTaskLogWindowY(), ExeConstant.TASK_LOG_WINDOW_WIDTH,
                ExeConstant.TASK_LOG_WINDOW_HEIGHT);
    }

    /**
     * 添加组件
     */
    public void addComponent(){
        Container c = getContentPane();
        c.setBackground(ExeConstant.COLOR_ONE);
        c.setLayout(new BorderLayout());
        c.add(new TaskLogPanel());
    }
}
