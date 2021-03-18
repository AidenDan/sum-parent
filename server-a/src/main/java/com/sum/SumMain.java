package com.sum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-2-27 21:35:40
 */

@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class SumMain {
    public static void main(String[] args) {
        SpringApplication.run(SumMain.class, args);
    }
}
