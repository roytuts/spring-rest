package com.roytuts.spring.rest.large.file.download.rest.controller;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.roytuts.spring.rest.large.file.download.dto.Input;

import reactor.core.publisher.Flux;

@RestController
public class FileDownloadRestController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/download/large/file1")
	public ResponseEntity<String> downloadFileUsingRestTemplate(@RequestBody Input input) {
		// Optional Accept header
		RequestCallback requestCallback = request -> request.getHeaders()
				.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

		// Streams the response instead of loading it all in memory
		ResponseExtractor<Void> responseExtractor = response -> {
			String filename = input.getDownloadUrl().substring(input.getDownloadUrl().lastIndexOf("/") + 1);

			Path path = Paths
					.get(input.getDownloadPath() == null ? "/" + filename : input.getDownloadPath() + "/" + filename);

			Files.copy(response.getBody(), path);

			return null;
		};

		// URL - https://speed.hetzner.de/100MB.bin, https://speed.hetzner.de/10GB.bin
		// URL - https://link.testfile.org/250MB, https://bit.ly/1GB-testfile
		restTemplate.execute(URI.create(input.getDownloadUrl()), HttpMethod.GET, requestCallback, responseExtractor);

		return new ResponseEntity<String>("File Downloaded Successfully", HttpStatus.OK);
	}

	@PostMapping("/download/large/file2")
	public ResponseEntity<String> downloadFileUsingWebClient(@RequestBody Input input) throws IOException {
		String filename = input.getDownloadUrl().substring(input.getDownloadUrl().lastIndexOf("/") + 1);
		Path path = Paths
				.get(input.getDownloadPath() == null ? "/" + filename : input.getDownloadPath() + "/" + filename);

		WebClient webClient = WebClient.builder().baseUrl(input.getDownloadUrl()).build();

		// Get file data
		Flux<DataBuffer> dataBufferFlux = webClient.get().accept(MediaType.APPLICATION_OCTET_STREAM)
				.retrieve().bodyToFlux(DataBuffer.class);

		// Streams the dataBufferFlux from response instead of loading it all in memory
		DataBufferUtils.write(dataBufferFlux, path, StandardOpenOption.CREATE).share().block();

		return new ResponseEntity<String>("File Downloaded Successfully", HttpStatus.OK);
	}

}
