package com.example.ravi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ravi.entity.Request;
import com.example.ravi.service.RequestService;

@RestController
public class UserController {
	@Autowired
	private RequestService Sequestservice;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveJsonDetails", method = RequestMethod.POST)
	public ResponseEntity saveJsonDetails(Request request) {
		log.info("inside method userDetails.");
		Sequestservice.saveJsonDetails(request);
		return new ResponseEntity("Json is saved", HttpStatus.CREATED);
	}

}
