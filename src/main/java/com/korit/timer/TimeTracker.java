package com.korit.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class TimeTracker {

    public static void main(String[] args) {

        SpringApplication.run(TimeTracker.class, args);



    }

}
