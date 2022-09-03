package com.phenom.swingview.config;

import ch.qos.logback.core.OutputStreamAppender;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author olic
 * @date 2022/9/315:38
 */
public class RpaExeConsoleAppender<E> extends OutputStreamAppender<E>{

    public static BufferedReader bufferedReader;

    @Override
    public void start() {

        // 管道读取流
        PipedInputStream pipedInputStream = new PipedInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(pipedInputStream, StandardCharsets.UTF_8));

        // 管道写入流
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        try {
            // 写入读取管道链接
            pipedOutputStream.connect(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置输出流到Appender
        super.setOutputStream(pipedOutputStream);
        super.start();
    }
}
