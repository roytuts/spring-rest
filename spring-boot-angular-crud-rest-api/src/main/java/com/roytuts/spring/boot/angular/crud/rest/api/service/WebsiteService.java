package com.roytuts.spring.boot.angular.crud.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.spring.boot.angular.crud.rest.api.converter.EntityVoConverter;
import com.roytuts.spring.boot.angular.crud.rest.api.repository.WebsiteRepository;
import com.roytuts.spring.boot.angular.crud.rest.api.vo.WebsiteVo;

@Service
public class WebsiteService {

	@Autowired
	private WebsiteRepository websiteRepository;

	public List<WebsiteVo> getWebsites() {
		System.out.println("Total Websites: " + websiteRepository.findAll().size());

		return EntityVoConverter.convertEntityToVoList(websiteRepository.findAll());
	}

	public WebsiteVo getWebsite(final Integer id) {
		if (id == null || id == 0) {
			throw new RuntimeException("You must provide valid website id");
		}

		WebsiteVo website = EntityVoConverter.convertEntityToVo(websiteRepository.findById(id).get());

		if (website == null) {
			throw new RuntimeException("Website detail not found for the given id => " + id);
		} else {
			return website;
		}
	}

	public void deleteWebsite(final Integer id) {
		if (id == null || id == 0) {
			throw new RuntimeException("You must provide valid website id");
		}

		try {
			websiteRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Website detail not found for the given id => " + id);
		}
	}

	public void saveWebsite(final WebsiteVo website) {
		if (website == null || (website.getTitle() == null && website.getUrl() == null)) {
			throw new RuntimeException("You must provide Website details");
		}

		try {
			websiteRepository.save(EntityVoConverter.convertVoToEntity(website));
		} catch (Exception e) {
			throw new RuntimeException("Error occurred during website details saving");
		}
	}

	public void updateWebsite(final WebsiteVo website) {
		if (website == null || ((website.getId() == null || website.getId() == 0) && website.getTitle() == null
				&& website.getUrl() == null)) {
			throw new RuntimeException("You must provide Website details");
		}

		try {
			websiteRepository.save(EntityVoConverter.convertVoToEntity(website));
		} catch (Exception e) {
			throw new RuntimeException("Error occurred during website details updating");
		}
	}

}
