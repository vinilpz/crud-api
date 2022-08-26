package com.crudexemplo.Crud.dto.viacep;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CepGetRequestBody {
    private Long id;
    private String bairro;
    private String cep;
    private String complemento;
    private String localidade;
    private String logradouro;
    private String numero;
    private String uf;

}
