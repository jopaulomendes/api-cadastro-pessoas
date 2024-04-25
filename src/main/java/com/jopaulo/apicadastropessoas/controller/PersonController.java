package com.jopaulo.apicadastropessoas.controller;

import com.jopaulo.apicadastropessoas.exception.PersonNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.jopaulo.apicadastropessoas.dto.request.PersonDTO;
import com.jopaulo.apicadastropessoas.dto.response.MessageResponseDTO;
import com.jopaulo.apicadastropessoas.service.PersonService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO create(@Valid @RequestBody PersonDTO dto) {
		return service.create(dto);
	}

	@GetMapping
	public List<PersonDTO> listAll(){
		return service.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return service.findById(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO update (@PathVariable Long id, @RequestBody PersonDTO dto) throws PersonNotFoundException {
		return service.update(id, dto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable  Long id) throws PersonNotFoundException {
		service.delete(id);
	}
}
