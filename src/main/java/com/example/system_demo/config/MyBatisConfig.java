package com.example.system_demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.system_demo.mapper")
public class MyBatisConfig {
}
