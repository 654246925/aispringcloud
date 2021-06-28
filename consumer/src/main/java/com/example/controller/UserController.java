package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Api("用户")
@RestController
@RequestMapping("/consumer")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8010/user/";

    @ApiOperation(value = "用户列表")
    @PostMapping("/findAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="页数",dataType="Integer", paramType = "query", required = true),
            @ApiImplicitParam(name="pageSize",value="条数",dataType="Integer", paramType = "query", required = true)
    })
    public Result findAll(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize){
        String result = restTemplate.getForObject(URL + "/findAll?pageNum="+pageNum+"&pageSize="+pageSize, String.class);
        return JSON.parseObject(result, Result.class);
    }


    @ApiOperation(value = "单个用户")
    @PostMapping("/findById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true)
    })
    public Result findById(@RequestParam Long id){
        return restTemplate.getForObject(URL + "findById", Result.class);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("/save")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = false),
            @ApiImplicitParam(name="name",value="名称",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="age",value="年龄",dataType="Long", paramType = "query", required = true)
    })
    public Result save(@ModelAttribute @Valid User user){
        return restTemplate.getForObject(URL + "save", Result.class);
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true),
            @ApiImplicitParam(name="name",value="名称",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="age",value="年龄",dataType="Long", paramType = "query", required = true)
    })
    public Result update(@ModelAttribute @Valid User user){
        return restTemplate.getForObject(URL + "update", Result.class);
    }

    @ApiOperation(value = "删除单个用户")
    @PostMapping("/deleteById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true)
    })
    public Result deleteById(@RequestParam Long id){
        return restTemplate.getForObject(URL + "deleteById", Result.class);
    }

}
