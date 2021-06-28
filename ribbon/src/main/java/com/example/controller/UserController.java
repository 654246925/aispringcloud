package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/ribbon")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8010/user/";

    @GetMapping("/findAll")
    public Result findAll(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize){
        String result = restTemplate.getForObject("http://provider/user/findAll?pageNum="+pageNum+"&pageSize="+pageSize, String.class);
        return JSON.parseObject(result, Result.class);
    }

    @GetMapping("/prot")
    public String index(){
        return  restTemplate.getForObject("http://provider/user/prot", String.class);
    }

}
