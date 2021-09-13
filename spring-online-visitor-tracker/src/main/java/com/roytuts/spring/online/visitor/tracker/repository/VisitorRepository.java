package com.roytuts.spring.online.visitor.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roytuts.spring.online.visitor.tracker.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

}
