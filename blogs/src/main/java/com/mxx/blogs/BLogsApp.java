package com.mxx.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BLogsApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext run= SpringApplication.run(BLogsApp.class);
    }
}
