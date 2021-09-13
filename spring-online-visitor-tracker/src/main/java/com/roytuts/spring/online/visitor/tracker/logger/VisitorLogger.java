package com.roytuts.spring.online.visitor.tracker.logger;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.roytuts.spring.online.visitor.tracker.entity.Visitor;
import com.roytuts.spring.online.visitor.tracker.service.VisitorService;
import com.roytuts.spring.online.visitor.tracker.utils.HttpRequestResponseUtils;

@Component
public class VisitorLogger implements HandlerInterceptor {

	@Autowired
	private VisitorService visitorService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		final String ip = HttpRequestResponseUtils.getClientIpAddress();
		final String url = HttpRequestResponseUtils.getRequestUrl();
		final String page = HttpRequestResponseUtils.getRequestUri();
		final String refererPage = HttpRequestResponseUtils.getRefererPage();
		final String queryString = HttpRequestResponseUtils.getPageQueryString();
		final String userAgent = HttpRequestResponseUtils.getUserAgent();
		final String requestMethod = HttpRequestResponseUtils.getRequestMethod();
		final LocalDateTime timestamp = LocalDateTime.now();

		Visitor visitor = new Visitor();
		visitor.setUser(HttpRequestResponseUtils.getLoggedInUser());
		visitor.setIp(ip);
		visitor.setMethod(requestMethod);
		visitor.setUrl(url);
		visitor.setPage(page);
		visitor.setQueryString(queryString);
		visitor.setRefererPage(refererPage);
		visitor.setUserAgent(userAgent);
		visitor.setLoggedTime(timestamp);
		visitor.setUniqueVisit(true);

		visitorService.saveVisitorInfo(visitor);

		return true;
	}

}
