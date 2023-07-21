package com.itshanhe.qiyunblogapi.util;


import java.time.Instant;

/**
 * 获取时间戳
 */
public class TimeUtil {
    /**
     * 获取当前时间戳
     * @return
     */
    public static long getNowCurrentTime() {
        return Instant.now().toEpochMilli();
    }
    
    /**
     * 指定时间戳
     * @param minutes 分钟
     * @return
     */
    public static long getSetCurrentTime(int minutes) {
        return Instant.now().plusSeconds(minutes * 60).toEpochMilli();
    }
}
