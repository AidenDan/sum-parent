package com.sum.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-2-27 22:17:03
 */

@Component
public class ScheduleTask {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // 每10秒执行一次该方法
    @Scheduled(cron = "0/10 * * * * ?")
    public void sumLogin() {
        Integer loginSum = (Integer) redisTemplate.opsForValue().get("loginSum");
        System.err.println("总访问次数达到:::" + (loginSum == null ? 0 : loginSum));
    }
}
