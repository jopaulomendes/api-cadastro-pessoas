package com.jopaulo.apicadastropessoas.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@lombok.Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

private Long id;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	private String birthDate;
	
	@NotEmpty
	@Valid
	private List<PhoneDTO> phones;
	
}
