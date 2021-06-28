package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.tool.PageBen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public PageBen findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        PageBen pageBen = new PageBen(pageInfo);
        return pageBen;
    }

    public User findById(Long id) {
        return userMapper.findById(id);
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void deleteById(long id) {
        userMapper.deleteById(id);
    }

}
