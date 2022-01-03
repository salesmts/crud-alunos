package com.osfdigital.crud.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.osfdigital.crud.model.Aluno;
import com.osfdigital.crud.repository.AlunoRepository;

public class AtualizarAlunoForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	private Integer idade;

	@NotNull
	@NotEmpty
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno atualizar(Long id, AlunoRepository alunoRepository) {
		Aluno aluno = alunoRepository.getById(id);
		aluno.setIdade(idade);
		aluno.setNome(nome);
		aluno.setSerie(serie);

		return aluno;
	}

}
