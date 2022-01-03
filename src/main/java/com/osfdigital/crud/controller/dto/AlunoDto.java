package com.osfdigital.crud.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.osfdigital.crud.model.Aluno;

public class AlunoDto {

	private Long id;
	private String nome;
	private Integer idade;
	private String serie;
	
	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.idade = aluno.getIdade();
		this.serie = aluno.getSerie();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public String getSerie() {
		return serie;
	}


	public static List<AlunoDto> converter(List<Aluno> alunos) {
	
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
	
	
	
}
