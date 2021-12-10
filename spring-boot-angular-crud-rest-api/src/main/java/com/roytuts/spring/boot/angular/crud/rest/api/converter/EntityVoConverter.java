package com.roytuts.spring.boot.angular.crud.rest.api.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.roytuts.spring.boot.angular.crud.rest.api.entity.Website;
import com.roytuts.spring.boot.angular.crud.rest.api.vo.WebsiteVo;

public final class EntityVoConverter {

	private EntityVoConverter() {
	}

	public static WebsiteVo convertEntityToVo(Website website) {
		WebsiteVo websiteVo = new WebsiteVo();
		websiteVo.setId(website.getId());
		websiteVo.setTitle(website.getTitle());
		websiteVo.setUrl(website.getUrl());

		return websiteVo;
	}

	public static Website convertVoToEntity(WebsiteVo websiteVo) {
		Website website = new Website();
		website.setId(websiteVo.getId());
		website.setTitle(websiteVo.getTitle());
		website.setUrl(websiteVo.getUrl());

		return website;
	}

	public static List<WebsiteVo> convertEntityToVoList(List<Website> websites) {
		return websites.stream().map(w -> {
			return convertEntityToVo(w);
		}).collect(Collectors.toList());
	}

	public static List<Website> convertVoToEntityList(List<WebsiteVo> websiteVos) {
		return websiteVos.stream().map(wvo -> {
			return convertVoToEntity(wvo);
		}).collect(Collectors.toList());
	}

}
