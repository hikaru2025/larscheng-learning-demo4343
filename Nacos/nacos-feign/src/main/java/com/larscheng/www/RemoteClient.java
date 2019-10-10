package com.larscheng.www;

import org.springframework.cloud.openfeign.DefaultHystrixFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: lars
 * @date: 2019/7/10 16:01
 * @description:
 */
@FeignClient(name = "nacos-provide",fallbackFactory = DefaultHystrixFallbackFactory.class)
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String helloNacos();
}
