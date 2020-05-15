package com.example.ravi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ravi.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{

}
