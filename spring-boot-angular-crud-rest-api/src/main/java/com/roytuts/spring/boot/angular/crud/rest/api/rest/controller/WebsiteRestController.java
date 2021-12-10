package com.roytuts.spring.boot.angular.crud.rest.api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roytuts.spring.boot.angular.crud.rest.api.service.WebsiteService;
import com.roytuts.spring.boot.angular.crud.rest.api.vo.WebsiteVo;

@RestController
@CrossOrigin(value = "*")
public class WebsiteRestController {

	@Autowired
	private WebsiteService websiteService;

	@GetMapping("/websites")
	public ResponseEntity<List<WebsiteVo>> getWebsites() throws Exception {
		return new ResponseEntity<List<WebsiteVo>>(websiteService.getWebsites(), HttpStatus.OK);
	}

	@GetMapping("/website/{id}")
	public ResponseEntity<WebsiteVo> getWebsite(@PathVariable Integer id) throws Exception {
		return new ResponseEntity<WebsiteVo>(websiteService.getWebsite(id), HttpStatus.OK);
	}

	@PostMapping("/website")
	public ResponseEntity<Void> saveWebsite(@RequestBody WebsiteVo website) throws Exception {
		websiteService.saveWebsite(website);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/website")
	public ResponseEntity<Void> updateWebsite(@RequestBody WebsiteVo website) throws Exception {
		websiteService.updateWebsite(website);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/website/{id}")
	public ResponseEntity<WebsiteVo> deleteWebsite(@PathVariable Integer id) throws Exception {
		websiteService.deleteWebsite(id);
		return new ResponseEntity<WebsiteVo>(HttpStatus.OK);
	}

}
