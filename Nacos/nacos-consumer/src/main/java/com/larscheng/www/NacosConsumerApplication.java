package com.larscheng.www;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xiemin
 * @date 2019/10/8 16:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
    @Resource
    private RemoteClient remoteClient;

    @GetMapping("/consumer")
    public String test() {
        return remoteClient.helloNacos();
    }
}
