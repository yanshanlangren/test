package iot.qing.utils;

import java.time.LocalDateTime;

public class LogUtils {
    public static void log(String content){
        String formated = String.format("[%s] %s", LocalDateTime.now(),content);
        System.out.println(formated);
    }

    public static void main(String[] args){
        log("hello world");
    }
}
