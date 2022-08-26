package com.crudexemplo.Crud.model;

import com.crudexemplo.Crud.dto.person.PersonPostRequestBody;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @CPF
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Address address;

    public static Person toPerson(PersonPostRequestBody personPostRequestBody) {
        return Person.builder()
                .id(personPostRequestBody.getId())
                .name(personPostRequestBody.getName())
                .email(personPostRequestBody.getEmail())
                .cpf(personPostRequestBody.getCpf())
                .build();
    }

}
