package com.roytuts.java.spring.concurrency.concurrent.calls;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConcurrentRunnerApp implements CommandLineRunner {

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentRunnerApp.class, args);// .close();
	}

	@Override
	public void run(String... args) throws Exception {
		Instant start = Instant.now();

		List<CompletableFuture<String>> allFutures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			allFutures.add(asyncService.callMsgService());
		}

		CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

		for (int i = 0; i < 10; i++) {
			System.out.println("response: " + allFutures.get(i).get().toString());
		}

		Instant finish = Instant.now();

		long timeElapsed = Duration.between(start, finish).toMillis();

		System.out.println("Total time: " + timeElapsed + " ms");

		System.exit(SpringApplication.exit(context));
	}

}
