package com.jopaulo.apicadastropessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jopaulo.apicadastropessoas.dto.response.MessageResponseDTO;
import com.jopaulo.apicadastropessoas.entity.Person;
import com.jopaulo.apicadastropessoas.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonController {

	@Autowired
	private PersonService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@RequestBody Person entity) {
		return service.create(entity);
	}
}
