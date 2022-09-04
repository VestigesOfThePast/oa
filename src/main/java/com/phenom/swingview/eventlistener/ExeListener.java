package com.phenom.swingview.eventlistener;

import com.phenom.swingview.constant.ExeConstant;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 监听工具类
 * @author olic
 * @date 2022/8/3110:28
 */
public class ExeListener {

    /**
     * 关闭确认框
     * @param jFrame
     */
    public static void closeConfirm(JFrame jFrame){
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int m = JOptionPane.showConfirmDialog(jFrame, ExeConstant.CLOSE_ALERT_MESSAGE, ExeConstant.ALERTTEXT, JOptionPane.YES_NO_OPTION);
                if (m==JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
}
