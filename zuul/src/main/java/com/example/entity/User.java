package com.example.entity;

import lombok.Data;

import java.io.Serializable;

@Data
//@ApiModel("用户")
public class User implements Serializable {

//    @ApiModelProperty(value = "用户id")
    private Long id;
//    @ApiModelProperty(value = "名称")
    private String name;
//    @ApiModelProperty(value = "年龄")
    private int age;

}
