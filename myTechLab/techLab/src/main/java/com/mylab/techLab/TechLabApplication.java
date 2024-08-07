package com.mylab.techLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TechLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechLabApplication.class, args);
    }

}
