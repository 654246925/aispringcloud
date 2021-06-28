package com.example.feign.impl;

import com.example.feign.FeignProviderClient;
import org.springframework.stereotype.Component;

@Component(value = "feignProviderClient")
public class FeignError implements FeignProviderClient {
    @Override
    public String findAll(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public String port() {
        return null;
    }
}
