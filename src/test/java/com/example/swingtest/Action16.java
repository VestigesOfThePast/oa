package com.example.swingtest;

import com.sun.glass.events.KeyEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author olic
 * @date 2022/8/2415:46
 */
public class Action16 extends JMenuBar {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Action16() {
        add(createFileMenu());    //添加文件菜单
        add(createEditMenu());    //添加编辑菜单
        setVisible(true);

    }

    public static void main(String[] agrs) {
        JFrame frame = new JFrame("菜单栏");
        frame.setSize(300, 200);
        frame.setJMenuBar(new Action16());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //定义文件菜单
    private JMenu createFileMenu() {
        JMenu menu = new JMenu("文件(F)");
        menu.setMnemonic(KeyEvent.VK_F);    //设置快速访问符
        JMenuItem item = new JMenuItem("新建(N)", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("打开(O)", KeyEvent.VK_O);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menu.add(item);
        item = new JMenuItem("保存(S)", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("退出(E)", KeyEvent.VK_E);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menu.add(item);
        return menu;
    }

    //定义“编辑”菜单
    private JMenu createEditMenu() {
        JMenu menu = new JMenu("编辑(E)");
        menu.setMnemonic(KeyEvent.VK_E);
        JMenuItem item = new JMenuItem("撤销(U)", KeyEvent.VK_U);
        item.setEnabled(false);
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("剪贴(T)", KeyEvent.VK_T);
        menu.add(item);
        item = new JMenuItem("复制(C)", KeyEvent.VK_C);
        menu.add(item);
        menu.addSeparator();
        JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("自动换行");
        menu.add(cbMenuItem);
        return menu;
    }
}
