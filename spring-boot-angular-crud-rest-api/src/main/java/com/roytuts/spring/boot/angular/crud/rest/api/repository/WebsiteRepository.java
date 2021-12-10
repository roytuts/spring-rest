package com.roytuts.spring.boot.angular.crud.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.boot.angular.crud.rest.api.entity.Website;

public interface WebsiteRepository extends JpaRepository<Website, Integer> {

}
