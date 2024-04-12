package com.jopaulo.apicadastropessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jopaulo.apicadastropessoas.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
