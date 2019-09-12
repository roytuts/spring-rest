package com.roytuts.spring.hateoas.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.roytuts.spring.hateoas.entity")
@EnableJpaRepositories("com.roytuts.spring.hateoas.repository")
public class SpringConfig {

}
