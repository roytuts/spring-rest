package com.jeejava.spring.hateoas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.jeejava.spring.hateoas.entity")
@EnableJpaRepositories("com.jeejava.spring.hateoas.repository")
public class SpringConfig {

}
