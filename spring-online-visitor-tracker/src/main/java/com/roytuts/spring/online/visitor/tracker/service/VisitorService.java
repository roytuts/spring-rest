package com.roytuts.spring.online.visitor.tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roytuts.spring.online.visitor.tracker.entity.Visitor;
import com.roytuts.spring.online.visitor.tracker.repository.VisitorRepository;

@Service
public class VisitorService {

	@Autowired
	private VisitorRepository repository;

	public Visitor saveVisitorInfo(Visitor visitor) {
		return repository.save(visitor);
	}

}
