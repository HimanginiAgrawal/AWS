package com.touchdine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Himangini Agrawal on 10-14-2017.
 */

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = "com.touchdine.repo")
@EntityScan(basePackages = "com.touchdine.model")
// Using a root package allows the use of @ComponentScan annotation without specifying a basePackage attribute
public class SpringBootConfig extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootConfig.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfig.class, args);            // starting application
    }
}
