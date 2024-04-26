package com.jopaulo.apicadastropessoas.service;

import com.jopaulo.apicadastropessoas.dto.request.PersonDTO;
import com.jopaulo.apicadastropessoas.dto.response.MessageResponseDTO;
import com.jopaulo.apicadastropessoas.entity.Person;
import com.jopaulo.apicadastropessoas.repository.PersonRepository;
import com.jopaulo.apicadastropessoas.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO dto = PersonUtils.createFakeDTO();
        Person expectdSavedPerson = PersonUtils.createFakeEntity();

        Mockito.when(repository.save(any(Person.class))).thenReturn(expectdSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectdSavedPerson.getId());
        MessageResponseDTO messageResponseDTO = service.create(dto);

        assertEquals(expectedSuccessMessage, messageResponseDTO);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com sucesso: " + id)
                .build();
    }

}
