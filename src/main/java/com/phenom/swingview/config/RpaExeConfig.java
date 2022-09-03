package com.phenom.swingview.config;

import com.phenom.swingview.thread.ConsoleMonitorThread;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author olic
 * @date 2022/9/322:40
 */
@Component
public class RpaExeConfig implements InitializingBean, DisposableBean {
    private static RpaExeConfig rpaExeConfig = null;
    public static RpaExeConfig getRpaConfig() {
        return rpaExeConfig;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        rpaExeConfig = this;
        ConsoleMonitorThread.getInstance().start();
    }

    @Override
    public void destroy() throws Exception {
        ConsoleMonitorThread.getInstance().toStop();
    }
}
