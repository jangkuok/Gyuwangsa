package com.gyuwangsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

    private static final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        logger.info("########## 메인 페이지 이동 ##########");
        return "mainPage";
    }
}
