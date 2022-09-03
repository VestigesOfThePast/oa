package com.phenom.swingview.thread;

import com.phenom.swingview.config.RpaExeConsoleAppender;
import com.phenom.swingview.jpanel.ConsolePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * @author olic
 * @Description rpaExe控制台日志
 * @date 2022/5/28 11:11
 */
public class ConsoleMonitorThread{

    private static Logger logger = LoggerFactory.getLogger(ConsoleMonitorThread.class);
    private static ConsoleMonitorThread instance = new ConsoleMonitorThread();
    public static ConsoleMonitorThread getInstance(){
        return instance;
    }
    private Thread monitorThread;
    private volatile boolean toStop = false;

    public void start(){
        monitorThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while(!toStop){
                    try{
                        String line = null;
                        while (true) {
                            try {
                                //控制台日志超过1000行刷新
                                if(ConsolePanel.jTextArea.getLineCount() > 1000){
                                    ConsolePanel.jTextArea.setText("");
                                }
                                line = RpaExeConsoleAppender.bufferedReader.readLine();
                                ConsolePanel.jTextArea.append(line+"\n");
                            } catch (IOException e) {
                                System.out.println(e.toString());
                            }
                        }
                    } catch (Exception e) {
                        if (!toStop) {
                            logger.error(">>>>>>>>>>> rpaExe, log monitor thread error:{}", e);
                        }
                    }
                }
                logger.info(">>>>>>>>>>> rpaExe, log monitor thread stop");
            }
        });
        monitorThread.setName("rpaExe, log monitor ConsoleMonitorThread");
        monitorThread.start();
    }

    public void toStop(){
        toStop = true;

        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

