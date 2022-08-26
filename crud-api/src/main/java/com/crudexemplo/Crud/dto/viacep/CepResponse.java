package com.crudexemplo.Crud.dto.viacep;

import com.crudexemplo.Crud.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepResponse {
    private Long id;
    private String bairro;
    private String cep;
    private String complemento;
    private String localidade;
    private String logradouro;
    private String numero;
    private String uf;

    public static CepResponse toCepResponse(Address address) {
        return CepResponse.builder()
                .id(address.getId())
                .bairro(address.getBairro())
                .cep(address.getCep())
                .complemento(address.getComplemento())
                .localidade(address.getLocalidade())
                .logradouro(address.getLogradouro())
                .numero(address.getNumero())
                .uf(address.getUf())
                .build();
    }

}
