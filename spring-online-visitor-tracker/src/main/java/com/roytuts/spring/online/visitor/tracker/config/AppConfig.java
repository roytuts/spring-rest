package com.roytuts.spring.online.visitor.tracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.roytuts.spring.online.visitor.tracker.logger.VisitorLogger;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private VisitorLogger visitorLogger;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(visitorLogger);
	}

}
