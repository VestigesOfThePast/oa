package com.phenom.swingview.jpanel;

import com.phenom.swingview.constant.UIConstant;
import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;

/**
 * 主机信息模块
 * @author olic
 * @date 2022/8/3013:39
 */
public class HostInfoPanel extends JPanel {
    private Logger logger = LoggerFactory.getLogger(HostInfoPanel.class);

    public HostInfoPanel(){
        init();
        addComponent();
    }

    public void init(){
        //设置边界模式下指定区域的大小
        setPreferredSize(new Dimension(150, 150));
        setBackground(UIConstant.COLOR_ONE);
        setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent() {
        add(getCenterPanel(), BorderLayout.CENTER);
    }

    /**
     * 表格组件
     * @return
     */
    public JPanel getCenterPanel(){
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String hostName = null;
        String osName = System.getProperty("os.name");
        int cpu = Runtime.getRuntime().availableProcessors();
        long memory = osmxb.getTotalPhysicalMemorySize()/1024/1024/1024L;
        String homeDir = System.getProperty("user.dir");
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        }catch (Exception e) {
            logger.error("获取本机用户名失败："+e.getMessage());
        }
        //定义一维数据作为列标题
        Object[] columnTitle = {"计算机属性" , "属性值"};
        Object[][] tableData =  new Object[][]{
                new Object[]{"计算机属性" , "属性值"},
                new Object[]{"主机名" , hostName},
                new Object[]{"操作系统" , osName},
                new Object[]{"UUID", "clientId"},
                new Object[]{"CPU" , cpu},
                new Object[]{"内存" , memory},
                new Object[]{"IPV4地址" , "ip"},
                new Object[]{"HOME目录" , homeDir},
                new Object[]{"客户端项目版本", "1.4"}
        };
        //以二维数组和一维数组来创建一个JTable对象
        JTable table = new JTable(tableData,columnTitle){
            //表格不允许被编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(45);
        table.setBackground(UIConstant.COLOR_SEVEN);
        table.setRowSelectionAllowed(true);
        //设置选中行颜色
        table.setSelectionBackground(UIConstant.COLOR_SIX);
        //保证每次只选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSize(700, 400);
        table.setIntercellSpacing(new Dimension(2,2));
        //设置第一列宽度为40
        table.getColumnModel().getColumn(0).setPreferredWidth(250);
        //设置表头颜色
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(UIConstant.COLOR_EIGHT);
        cellRenderer.setFont(new Font("宋体",Font.BOLD,16));
        table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer();
        cellRenderer1.setBackground(UIConstant.COLOR_ONE);
        //内容居中
        cellRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
        //设置第二列宽度为120
        table.getColumnModel().getColumn(1).setPreferredWidth(450);
        table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer1);
        panelCenter.add(table);
        return panelCenter;
    }

}
