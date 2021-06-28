package com.example.feign;

import com.example.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider", fallback = FeignError.class)
public interface FeignProviderClient {

    @GetMapping("/user/findAll")
    public String findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize);

    @GetMapping("/user/port")
    public String port();
}
