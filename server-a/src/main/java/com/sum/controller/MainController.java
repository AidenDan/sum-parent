package com.sum.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-2-27 21:57:29
 */

@CrossOrigin
@RestController
public class MainController {

    @GetMapping("/testLogin")
    public Object testLoginNumbers(HttpServletRequest request) {
        int serverPort = request.getServerPort();
        System.err.println("端口为:::" + serverPort);
        return "serverPort:" + serverPort;
    }
}
