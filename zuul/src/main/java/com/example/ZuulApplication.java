package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * `@EnableZuulProxy`：包含了 `@EnableZuulServer`，设置该类是网关的启动类。
 *
 * `@EnableAutoConfiguration`：可以帮助 Spring Boot 应用将所有符合条件的 `@Configuration` 配置加载到当前 Spring Boot 创建并使用的 IoC 容器中。
 *
 * - Zuul 自带了负载均衡功能，修改 provider 的代码。
 */
@EnableZuulProxy
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
