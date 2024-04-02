package com.gyuwangsa.controller;

import com.gyuwangsa.service.ExampleService;
import com.gyuwangsa.vo.ExampleVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class ExampleController {

    @Resource(name = "exampleService")
    private ExampleService exampleService;

    @RequestMapping(value = "/example.do", method = RequestMethod.GET)
    public String ExampleMain() {
        return "example";
    }

    @RequestMapping(value = "/exampleList.do", method = RequestMethod.GET)
    public String selectListExample(Model model) throws Exception {

        List<ExampleVO> list = exampleService.selectListExample();

        model.addAttribute("exampleList", list);

        return "exampleList";
    }

}

