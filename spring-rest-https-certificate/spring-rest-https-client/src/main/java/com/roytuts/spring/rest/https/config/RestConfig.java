package com.roytuts.spring.rest.https.config;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.function.Supplier;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.requestFactory(myRequestFactorySupplier()).build();
	}

	@Bean
	public MyRequestFactorySupplier myRequestFactorySupplier() {
		return new MyRequestFactorySupplier();
	}

	class MyRequestFactorySupplier implements Supplier<ClientHttpRequestFactory> {

		@Override
		public ClientHttpRequestFactory get() {
			HttpComponentsClientHttpRequestFactory requestFactory = null;
			try {
				char[] password = "changeit".toCharArray();
				KeyStore ks = KeyStore.getInstance("JKS");
				InputStream ksStream = this.getClass().getClassLoader().getResourceAsStream("javaclient.jks");
				ks.load(ksStream, password);

				SSLContext sslContext = new SSLContextBuilder()
						.loadTrustMaterial(this.getClass().getClassLoader().getResource("certificate.jks"), password)
						.loadKeyMaterial(ks, password).build();

				SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext,
						NoopHostnameVerifier.INSTANCE);

				CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLSocketFactory(socketFactory).build();

				requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
				requestFactory.setBufferRequestBody(false);
			} catch (Exception e) {
			}

			return requestFactory;
		}

	}
}
