package com.lgd.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgd.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","Hello!SpringMVC's annotation");
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model){
        model.addAttribute("msg","hello2");
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/hello3")
    public String hello3(User user){
        System.out.println(user);
        return "hello";
    }

    @RequestMapping("/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        User user = new User(1,"lgd",18);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/json2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        User user1 = new User(1,"lgd",18);
        User user2 = new User(2,"lgd",18);
        User user3 = new User(3,"lgd",18);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user1);
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(list);
        return str;
    }
}
