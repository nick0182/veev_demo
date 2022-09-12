package com.veev.veev_demo;

import com.veev.veev_demo.schedule.LogScheduler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VeevDemoApplication {

    @Value("${openhab.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(VeevDemoApplication.class, args);
    }

    @Bean
    LogScheduler logScheduler(RestTemplateBuilder restTemplateBuilder) {
        return new LogScheduler(url, restTemplateBuilder.build());
    }

}
