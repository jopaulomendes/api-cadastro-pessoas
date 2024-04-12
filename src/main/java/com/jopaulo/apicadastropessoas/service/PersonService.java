package com.jopaulo.apicadastropessoas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jopaulo.apicadastropessoas.dto.response.MessageResponseDTO;
import com.jopaulo.apicadastropessoas.entity.Person;
import com.jopaulo.apicadastropessoas.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Transactional
	public MessageResponseDTO create(Person entity) {
		Person person = repository.save(entity);
		return MessageResponseDTO
				.builder()
				.message("Pessoa criada com sucesso: " + person.getFirtName()+" "+person.getLastName())
				.build();
	}
}
