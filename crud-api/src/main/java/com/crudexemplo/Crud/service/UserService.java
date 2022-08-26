package com.crudexemplo.Crud.service;

import com.crudexemplo.Crud.dto.person.PersonPostRequestBody;
import com.crudexemplo.Crud.dto.person.PersonResponse;
import com.crudexemplo.Crud.exception.notfound.NotFoundException;
import com.crudexemplo.Crud.model.Address;
import com.crudexemplo.Crud.model.Person;
import com.crudexemplo.Crud.repository.CepRepository;
import com.crudexemplo.Crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;
    private final CepRepository cepRepository;

    public List<PersonResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(PersonResponse::toPersonResponse)
                .toList();
    }

    public List<Person> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public PersonResponse create(PersonPostRequestBody personPostRequestBody) {

        Address body = restTemplate.getForEntity(
                "https://viacep.com.br/ws/" + personPostRequestBody.getCep() + "/json/",
                Address.class).getBody();
        Person savePerson = userRepository.save(Person.toPerson(personPostRequestBody));

        if (Objects.nonNull(body)) {
            Address build = Address.builder()
                    .id(body.getId())
                    .bairro(body.getBairro())
                    .cep(body.getCep())
                    .complemento(personPostRequestBody.getComplemento())
                    .localidade(body.getLocalidade())
                    .logradouro(body.getLogradouro())
                    .numero(personPostRequestBody.getNumero())
                    .uf(body.getUf())
                    .build();
            Address save = cepRepository.save(build);
            savePerson.setAddress(save);
            return PersonResponse.toPersonResponse(userRepository.save(savePerson));
        }
        throw new NotFoundException("Not Found");
    }

    public Person findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found " + "ID: " + id));
    }

    public void deleteById(Long id) {
        this.userRepository.delete(findById(id));
    }

//    public void edit(PersonPutRequestBody personPutRequestBody) {
//        deleteById(personPutRequestBody.getId());
//        personPutRequestBody.setId(personPutRequestBody.getId());
//        userRepository.save(PersonMapper.INSTANCE.toPerson(personPutRequestBody));
//    }
}
