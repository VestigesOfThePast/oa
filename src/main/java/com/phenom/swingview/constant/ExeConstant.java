package com.phenom.swingview.constant;

import java.awt.*;

/**
 * @author olic
 * @date 2022/8/2911:04
 */
public class ExeConstant {

    /**
     * 软件名称,版本
     */
    public final static String APP_NAME = "JRRpa";
    public final static String APP_VERSION = "v_1.0.0";

    public final static String alertTit = "系统提示";
    public final static String alertText = "已经存在执行任务，请停止后再执行。";
    public final static String alertStopText = "当前执行任务，是否停止?";
    public final static String chooseWork = "请先选择任务再执行";
    public final static String confirmDoWork = "是否执行任务？";
    public final static String workStoped = "任务已经停止";

    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * 系统当前路径
     */
//    public final static String CURRENT_DIR = RPAConfig.jarPath();

    /**
     * 进度条容器高度
     */
    public final static int JProgressBar_Height = 300;
    public final static int console_Height = 500;

    /**
     * 颜色一
     */
    public final static Color COLOR_ONE = new Color(255, 255, 255);
    /**
     * 颜色二
     */
    public final static Color COLOR_TWO = new Color(221,221,221);
    /**
     * 颜色三
     */
    public final static Color COLOR_THREE = new Color(66,80,100);
    /**
     * 颜色四
     */
    public final static Color COLOR_FOUR = new Color(66,80,101);
    /**
     * 颜色五
     */
    public final static Color COLOR_FIVE = new Color(55,96,242);
    /**
     * 颜色六
     */
    public final static Color COLOR_SIX = new Color(0,0,0);
    /**
     * 颜色七
     */
    public final static Color COLOR_SEVEN = new Color(225,225,225);
    /**
     * 颜色八
     */
    public final static Color COLOR_EIGHT = new Color(238,238,238);
    /**
     * 颜色九
     */
    public final static Color COLOR_NINE = new Color(187,187,187);

    /**
     * 功能菜单枚举
     */
    public enum MenuEnum{
        HOST_INFO("host_info","主机信息"),
        TASK_LIST("task_list", "任务列表"),
        CONTROL("control","控制台");

        private final String code;
        private final String name;

        MenuEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(String code) {
            for (MenuEnum e : MenuEnum.values()) {
                if (code.equals(e.getCode())) {
                    return e.getName();
                }
            }
            return null;
        }
    }


    // 主窗体
    /** 主窗体-宽度 */
    public final static int MAIN_WINDOW_WIDTH = (int) (screenSize.getWidth()/1.3);
    /** 主窗体-高度 */
    public final static int MAIN_WINDOW_HEIGHT = (int) (screenSize.getHeight()/1.3);
    /** 主窗体-X坐标 */
    public static int getMainWindowX() { return screenSize.width / 2 - MAIN_WINDOW_WIDTH / 2; }
    /** 主窗体-Y坐标 */
    public static int getMainWindowY() { return screenSize.height / 2 - MAIN_WINDOW_HEIGHT / 2;}
    /** 主窗体-title */
    public final static String MAIN_WINDOW_TITLE = "RPA";

    // 登录窗体
    /** 登录窗体-宽度 */
    public final static int LOGIN_WINDOW_WIDTH = (int) (screenSize.getWidth()/4.0);
    /** 登录窗体-高度 */
    public final static int LOGIN_WINDOW_HEIGHT = (int) (screenSize.getWidth()/4.0);
    /** 登录窗体-X坐标 */
    public static int getLoginWindowX(){ return screenSize.width / 3 - LOGIN_WINDOW_WIDTH / 3;}
    /** 登录窗体-Y坐标 */
    public static int getLoginWindowwY(){ return screenSize.height / 3 - LOGIN_WINDOW_HEIGHT / 3;}
    /** 登录窗体-title */
    public final static String LOGIN_WINDOW_TITLE = "RPA登录";
    public final static String ALERTTEXT = "提示";
    //关闭提示短语
    public final static String CLOSE_ALERT_MESSAGE = "关闭窗体也会关闭RPA程序。是否关闭项目?";


    //执行器信息窗体
    /** 执行器信息窗体-title */
    public final static String EXE_INFO_WINDOW_TITLE = "主机信息";

    //任务日志窗体
    /** 主窗体-宽度 */
    public final static int TASK_LOG_WINDOW_WIDTH = (int) (screenSize.getWidth()/1.8);
    /** 主窗体-高度 */
    public final static int TASK_LOG_WINDOW_HEIGHT = (int) (screenSize.getHeight()/1.8);
    /** 主窗体-X坐标 */
    public static int getTaskLogWindowX() { return screenSize.width / 2 - MAIN_WINDOW_WIDTH / 4; }
    /** 主窗体-Y坐标 */
    public static int getTaskLogWindowY() { return screenSize.height / 2 - MAIN_WINDOW_HEIGHT / 4;}
    /** 任务日志窗体-日志详情 */
    public final static String TASK_LOG_WINDOW_TITLE = "日志详情";


    // 任务列表模块
    /** 任务列表模块-title */
    public final static String TASK_LIST_PANEL_TITLE = "任务列表";
    /** 任务列表模块-任务行间距 */
    public final static int TASK_LIST_PANEL_ROW_GAP = 30;

    // 控制台模块
    /** 控制台模块-title */
    public final static String CONSOLE_PANEL_TITLE = "控制台";
    public final static int CONSOLE_LOG_MAX_NUM = 500;

    // 执行器信息模块
    /** 执行器信息-log抬头*/
    public final static String EXE_INFO_PANEL_LOGO_TITLE = "君润人力";
    /** 主窗口图标 */
    public final static String EXE_INFO_PANEL_LOGO_IMG = "src/main/java/com/phenom/swingview/img/titIcon.png";

    // 登录模块
    /** 登录模块-上部提示 */
    public final static String LOGIN_PANEL_UP_TIPS = "请使用企业微信扫码登录";
    /** 登录模块-底部提示 */
    public final static String LOGIN_PANEL_DOWN_TIPS = "仅支持君润企业微信账号扫码登录";
    /** 登录模块-企微小图标 */
    public final static String LOGIN_PANEL_LOGO_TIPS = "src/main/java/com/phenom/swingview/img/qwcon.png";

}