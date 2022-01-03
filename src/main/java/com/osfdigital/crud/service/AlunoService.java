package com.osfdigital.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.osfdigital.crud.model.Aluno;
import com.osfdigital.crud.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	
	public List<Aluno> consultarAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno cadastrarAlunos(Long id, String nome, Integer idade, String serie) {
		Aluno aluno = new Aluno(id, nome, idade, serie);
		
//	    	Apenas para popular o banco de dados!!!    
//	        for(int i=1; i<50000;i++){
//	            aluno = new Aluno(id, "nomeDoAluno", 23, "Qualquer ano do Ensino médio");
//	            alunoRepository.save(aluno);
//	        }
	        
		return alunoRepository.save(aluno);
	}


	public Aluno atualizarAluno(Long id, String nome, Integer idade, String serie) {
		Aluno aluno = alunoRepository.getById(id);

		aluno.setNome(nome);
		aluno.setIdade(idade);
		aluno.setSerie(serie);

		return aluno;
	}

	public Aluno consultarAluno(@PathVariable Long id) {

		Aluno aluno = alunoRepository.getById(id);

		return aluno;

	}

	public boolean removerAluno(Long id) {
		alunoRepository.deleteById(id);

		return true;
	}

}
