package com.jopaulo.apicadastropessoas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jopaulo.apicadastropessoas.dto.request.PersonDTO;
import com.jopaulo.apicadastropessoas.dto.response.MessageResponseDTO;
import com.jopaulo.apicadastropessoas.entity.Person;
import com.jopaulo.apicadastropessoas.mapper.PersonMapper;
import com.jopaulo.apicadastropessoas.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	private final PersonMapper mapper = PersonMapper.INSTANCE;
	
	@Transactional
	public MessageResponseDTO create(PersonDTO dto) {
		Person entity = mapper.toModel(dto);
				
		Person person = repository.save(entity);
		return MessageResponseDTO
				.builder()
				.message("Pessoa criada com sucesso: " + person.getFirstName()+" "+person.getLastName())
				.build();
	}
//	https://github.com/rpeleias/personApi/tree/master  mapstruct
}
