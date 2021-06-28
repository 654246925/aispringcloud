package com.example.controller;

import com.example.entity.User;
import com.example.result.Result;
import com.example.result.ResultGenerator;
import com.example.service.UserService;
import com.example.tool.PageBen;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    @GetMapping("/port")
    public Result port(){
        return ResultGenerator.genSuccessResult(port);
    }

    @ApiOperation(value = "用户列表")
    @GetMapping("/findAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name="pageNum",value="页数",dataType="Integer", paramType = "query", required = true),
            @ApiImplicitParam(name="pageSize",value="条数",dataType="Integer", paramType = "query", required = true)
    })
    public Result findAll(@RequestParam Integer pageNum,
                              @RequestParam Integer pageSize){
        PageBen pageBen = userService.findAll(pageNum, pageSize);
        return ResultGenerator.genSuccessResult(pageBen);
    }

    @ApiOperation(value = "单个用户")
    @PostMapping("/findById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true)
    })
    public Result findById(@RequestParam Long id){
        User user = userService.findById(id);
        return ResultGenerator.genSuccessResult(user);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("/save")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = false),
            @ApiImplicitParam(name="name",value="名称",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="age",value="年龄",dataType="Long", paramType = "query", required = true)
    })
    public Result save(@ModelAttribute @Valid User user){
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改用户")
    @PostMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true),
            @ApiImplicitParam(name="name",value="名称",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="age",value="年龄",dataType="Long", paramType = "query", required = true)
    })
    public Result update(@ModelAttribute @Valid User user){
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "删除单个用户")
    @PostMapping("/deleteById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="用户id",dataType="Long", paramType = "query", required = true)
    })
    public Result deleteById(@RequestParam Long id){
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

}
