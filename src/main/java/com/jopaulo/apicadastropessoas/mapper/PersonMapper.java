package com.jopaulo.apicadastropessoas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.jopaulo.apicadastropessoas.dto.request.PersonDTO;
import com.jopaulo.apicadastropessoas.entity.Person;

@Mapper
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(final PersonDTO dto);
	
	PersonDTO toDTO(final Person person);
}
