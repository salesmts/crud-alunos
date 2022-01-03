package com.osfdigital.crud.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osfdigital.crud.model.Aluno;
import com.osfdigital.crud.repository.AlunoRepository;

public class AlunoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull
	private Integer idade;
	
	@NotNull @NotEmpty
	private String serie;
	private Long id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Aluno converter(AlunoRepository alunoRepository) {
		
				
		return new Aluno(id, nome, idade, serie);
	}

}
