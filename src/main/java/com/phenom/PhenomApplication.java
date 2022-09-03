package com.phenom;

import com.phenom.swingview.window.LoginFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication
public class PhenomApplication
{
    public static void main(String[] args)
    {
        new LoginFrame().start();
    }
}
