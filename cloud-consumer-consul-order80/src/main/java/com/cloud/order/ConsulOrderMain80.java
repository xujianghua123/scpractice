package com.cloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsulOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderMain80.class, args);
    }

   /* @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useClusterServers()
                .addNodeAddress("")
                .addNodeAddress("")
                .addNodeAddress("");
        return (Redisson)Redisson.create(config);
    }*/
}
