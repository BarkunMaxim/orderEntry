package com.netcracker.barkun.service.config;

import com.netcracker.barkun.dao.CustomerDao;
import com.netcracker.barkun.dao.impl.CustomerDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.netcracker.barkun.service.implementation")
public class CustomerServiceConfig {

    @Bean
    public CustomerDao customerService(){
        return new CustomerDaoImpl();
    }
}
