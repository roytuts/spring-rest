package com.roytuts.spring.rest.multiple.files.upload.rest.controller;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.annotation.MultipartConfig;

@RestController
/*@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 10)*/
public class MultipleFileUploadRestController {

	private static final Logger logger = LoggerFactory.getLogger(MultipleFileUploadRestController.class.getName());

	@PostMapping("/upload/multiple/files")
	public ResponseEntity<String> uploadMultipleFiles(@RequestParam("multipleFiles") MultipartFile[] files)
			throws Exception {

		if (files == null || files.length == 0) {
			throw new RuntimeException("You must select at least one file for uploading");
		}

		StringBuilder sb = new StringBuilder(files.length);

		for (int i = 0; i < files.length; i++) {
			InputStream inputStream = files[i].getInputStream();
			String originalName = files[i].getOriginalFilename();
			String name = files[i].getName();
			String contentType = files[i].getContentType();
			long size = files[i].getSize();

			sb.append("File Name: " + originalName + "\n");

			logger.info("InputStream: " + inputStream);
			logger.info("OriginalName: " + originalName);
			logger.info("Name: " + name);
			logger.info("ContentType: " + contentType);
			logger.info("Size: " + size);
		}

		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

	@PostMapping("/upload/multiple/files2")
	public ResponseEntity<String> uploadMultipleFiles(@RequestParam("multipleFiles") List<MultipartFile> files)
			throws Exception {

		if (files == null || files.isEmpty()) {
			throw new RuntimeException("You must select at least one file for uploading");
		}

		StringBuilder sb = new StringBuilder(files.size());

		for (int i = 0; i < files.size(); i++) {
			InputStream inputStream = files.get(i).getInputStream();
			String originalName = files.get(i).getOriginalFilename();
			String name = files.get(i).getName();
			String contentType = files.get(i).getContentType();

			sb.append("File Name: " + originalName + "\n");

			logger.info("InputStream: " + inputStream);
			logger.info("OriginalName: " + originalName);
			logger.info("Name: " + name);
			logger.info("ContentType: " + contentType);
			logger.info("Size: " + files.size());
		}

		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}

}
