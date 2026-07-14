package com.mycopilotx.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mycopilotx")
public class MyCopilotXApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCopilotXApplication.class, args);
    }
}
