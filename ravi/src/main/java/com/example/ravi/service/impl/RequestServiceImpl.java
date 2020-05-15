package com.example.ravi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ravi.entity.Request;
import com.example.ravi.jpa.RequestRepository;
import com.example.ravi.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository repository;

	@Override
	public void saveJsonDetails(Request request) {
		repository.save(request);
	}

}
