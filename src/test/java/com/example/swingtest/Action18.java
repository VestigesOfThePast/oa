package com.example.swingtest;

import javax.swing.*;

/**
 * @author olic
 * @date 2022/8/2416:12
 */

public class Action18 {
    public Action18() {
        // TODO Auto-generated constructor stub

        JOptionPane.showMessageDialog(null, "用户名或密码错误！", "错误 ", 0);
        JOptionPane.showMessageDialog(null, "请注册或登录...", "提示", 1);
        JOptionPane.showMessageDialog(null, "普通会员无权执行删除操作！", "警告", 2);
        JOptionPane.showMessageDialog(null, "你是哪一位？请输入用户名", "问题", 3);
        JOptionPane.showMessageDialog(null, "扫描完毕，没有发现病毒！", "提示", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new Action18();
    }
}
