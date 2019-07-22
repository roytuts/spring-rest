package com.jeejava.spring.boot.rest.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeejava.spring.boot.rest.caching.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByName(String name);

}
