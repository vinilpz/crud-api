package com.crudexemplo.Crud.repository;

import com.crudexemplo.Crud.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Address, Long> {
}
