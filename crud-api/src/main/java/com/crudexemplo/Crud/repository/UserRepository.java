package com.crudexemplo.Crud.repository;

import com.crudexemplo.Crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
}
