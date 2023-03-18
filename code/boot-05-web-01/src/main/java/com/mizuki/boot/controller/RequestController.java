package com.mizuki.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RequestController {

    @GetMapping("/goto")
    public String goTo(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        return "forward:/success";
    }

    @ResponseBody // 作用：将返回值转换为json格式
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("annotation_msg", msg);
        map.put("request_msg", request.getAttribute("msg"));
        return map;
    }

    @GetMapping("/cars/{path}")
    public Map<String, Object> cars(@PathVariable("path") String path,
                                    @MatrixVariable("low") Integer low,
                                    @MatrixVariable("brand") List<String> brand) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("path", path);
        map.put("low", low);
        map.put("brand", brand);

        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
