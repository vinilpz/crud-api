package com.crudexemplo.Crud.dto.person;

import com.crudexemplo.Crud.dto.viacep.CepResponse;
import com.crudexemplo.Crud.model.Person;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private CepResponse cepResponse;

    public static PersonResponse toPersonResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .cpf(person.getCpf())
                .cepResponse(CepResponse.toCepResponse(person.getAddress()))
                .build();
    }

}
