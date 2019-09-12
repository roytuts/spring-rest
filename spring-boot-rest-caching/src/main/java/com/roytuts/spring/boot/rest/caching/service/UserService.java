package com.roytuts.spring.boot.rest.caching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.roytuts.spring.boot.rest.caching.entity.User;
import com.roytuts.spring.boot.rest.caching.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Cacheable("users")
	public List<User> getUserList() {
		return repository.findAll();
	}

	@Cacheable("user-id")
	public User getUserById(int id) {
		return repository.findById(id).get();
	}

	@Cacheable("user-name")
	public User getUserByName(String name) {
		return repository.findByName(name);
	}

}
