package com.roytuts.spring.rest.multiple.files.upload.client;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class FileUploadClient {

	public static void main(String[] args) throws IOException {
		testMultipleFilesUpload();
		testMultipleFilesUpload2();
	}

	public static void testMultipleFilesUpload() throws IOException {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("multipleFiles",
				new FileSystemResource(new File("C:\\additional.properties")));
		map.add("multipleFiles", new FileSystemResource(
				new File("C:\\recommended pre-requisites.docx")));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> reqEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> resE = restTemplate.exchange("http://localhost:8080/upload/multiple/files",
				HttpMethod.POST, reqEntity, String.class);

		System.out.println(resE);
	}
	
	public static void testMultipleFilesUpload2() throws IOException {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("multipleFiles",
				new FileSystemResource(new File("C:\\additional.properties")));
		map.add("multipleFiles", new FileSystemResource(
				new File("C:\\recommended pre-requisites.docx")));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		HttpEntity<LinkedMultiValueMap<String, Object>> reqEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> resE = restTemplate.exchange("http://localhost:8080/upload/multiple/files2",
				HttpMethod.POST, reqEntity, String.class);

		System.out.println(resE);
	}

}
