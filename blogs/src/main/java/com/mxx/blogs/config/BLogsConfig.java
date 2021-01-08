package com.mxx.blogs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mxx.blogs.mapper")
public class BLogsConfig {
}
