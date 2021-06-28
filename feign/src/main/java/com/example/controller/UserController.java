package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.feign.FeignProviderClient;
import com.example.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/feign")
public class UserController {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Result findAll(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize){
        String result = feignProviderClient.findAll(pageNum, pageSize);
        return JSON.parseObject(result, Result.class);
    }

    @GetMapping("/port")
    public String port(){
        return  feignProviderClient.port();
    }

}
