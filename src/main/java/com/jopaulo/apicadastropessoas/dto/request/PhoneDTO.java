package com.jopaulo.apicadastropessoas.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.jopaulo.apicadastropessoas.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@lombok.Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;
}
