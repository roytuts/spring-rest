package com.roytuts.spring.resttemplate.proxy.timeout;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		HttpHost httpHost = new HttpHost("proxy-cloud.example.com", 8080);

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		clientBuilder.setProxy(httpHost);

		HttpClient httpClient = clientBuilder.build();

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		//HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		// factory.setHttpClient(httpClient);
		factory.setConnectionRequestTimeout(1000);
		factory.setConnectTimeout(1000);
		factory.setReadTimeout(1000);

		return builder.requestFactory(() -> factory).build();
	}

	@Bean
	public RestTemplate restTemplate() {
		HttpHost httpHost = new HttpHost("proxy-cloud.example.com", 8080);

		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		clientBuilder.setProxy(httpHost);

		HttpClient httpClient = clientBuilder.build();

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		////HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		// factory.setHttpClient(httpClient);
		factory.setConnectionRequestTimeout(1000);
		factory.setConnectTimeout(1000);
		factory.setReadTimeout(1000);

		return new RestTemplate(factory);
	}

}
