package com.mizuki.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    // 显示欢迎页
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    // 处理user请求
    @GetMapping("/user")
    public String getUser() {
        return "getUser";
    }

    @PostMapping("/user")
    public String postUser() {
        return "postUser";
    }

    @DeleteMapping("/user")
    public String deleteUser() {
        return "deleteUser";
    }

    @PutMapping("/user")
    public String putUser() {
        return "putUser";
    }


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> map(@PathVariable Integer id,
                                   @PathVariable String username,
                                   @RequestHeader("User-Agent") String userAgent,
                                   @RequestHeader Map<String, String> headers,
                                   @RequestParam("age") Integer age,
                                   @RequestParam("inters") String[] inters,
                                   @RequestParam Map<String, String> params
//                                   @CookieValue Map<String, String> cookies,
//                                   @CookieValue("_ga") String _ga
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("userAgent", userAgent);
        map.put("headers", headers);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
//        map.put("cookies", cookies);
//        map.put("_ga", _ga);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> map(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);

        return map;
    }
}
