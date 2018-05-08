package com.buzhou.exchange.match.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class TestController {
    private static Logger logger = LogManager.getLogger(TestController.class);

    @ApiOperation(value="根路径", httpMethod="GET", notes="这是一个hello world")
    @GetMapping("/")
    public String HelloWorld() {
        logger.info("****Hello World!****");
        return "Hello World!";
    }

    @GetMapping("/zeroException")
    public int ZeroException() {
        return 100/0;
    }
}
