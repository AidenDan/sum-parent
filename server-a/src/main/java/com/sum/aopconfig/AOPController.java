package com.sum.aopconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-8-23 23:08:56
 */
@Component
@Aspect
public class AOPController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @Around(value = "execution(* com.sum.controller.MainController.testLoginNumbers(..))")
    public Object sumLoginNum(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest) arg;
                System.err.println("方法的request.getServletPath():" + request.getServletPath());
            }
        }

        // 获取该接口的请求次数
        Integer loginSum = (Integer) redisTemplate.opsForValue().get("loginSum");
        if (loginSum == null) {
            loginSum = 1;
            // 如果是第一次访问
        } else {
            loginSum = loginSum + 1;
        }
        redisTemplate.opsForValue().set("loginSum", loginSum);

        // 执行被增强方法
        Object proceed = point.proceed();
        System.err.println("接口的访问次数达到:" + loginSum);
        System.err.println("被增强方法执行完毕......");
        return proceed;
    }
}
