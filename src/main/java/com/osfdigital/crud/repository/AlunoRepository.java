package com.osfdigital.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osfdigital.crud.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
