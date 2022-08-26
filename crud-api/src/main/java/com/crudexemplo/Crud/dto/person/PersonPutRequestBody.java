package com.crudexemplo.Crud.dto.person;

import lombok.Data;

@Data
public class PersonPutRequestBody {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String cep;
    private String numero;
    private String complemento;
}
