package com.crudexemplo.Crud.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String cep;
    private String complemento;
    private String localidade;
    private String logradouro;
    private String numero;
    private String uf;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Person person;


}
