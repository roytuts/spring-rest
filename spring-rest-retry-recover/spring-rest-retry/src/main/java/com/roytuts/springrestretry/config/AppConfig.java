package com.roytuts.springrestretry.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.RestTemplate;

import com.roytuts.springrestretry.custom.CustomRetryPolicy;

@Configuration
public class AppConfig {

	@Value("${retry.maxAttempts:3}")
	private int maxAttempts;

	@Value("${retry.backoffInMillis:1000}")
	private long backoffInMillis;

	@Bean
	public RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();

		FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
		backOffPolicy.setBackOffPeriod(backoffInMillis);
		retryTemplate.setBackOffPolicy(backOffPolicy);

		CustomRetryPolicy retryPolicy = new CustomRetryPolicy(maxAttempts);
		retryTemplate.setRetryPolicy(retryPolicy);

		return retryTemplate;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
