package com.assessment.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarageApplication.class, args);
    }

}
