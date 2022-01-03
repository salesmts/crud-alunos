package com.osfdigital.crud.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.osfdigital.crud.controller.dto.AlunoDto;
import com.osfdigital.crud.controller.form.AlunoForm;
import com.osfdigital.crud.controller.form.AtualizarAlunoForm;
import com.osfdigital.crud.model.Aluno;
import com.osfdigital.crud.repository.AlunoRepository;
import com.osfdigital.crud.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping
	public List<AlunoDto> listaAlunos() {
		List<Aluno> alunos = alunoService.consultarAlunos();

		return AlunoDto.converter(alunos);
	}

	@PostMapping
	public ResponseEntity<AlunoDto> cadastrarAlunos(@RequestBody @Valid AlunoForm form,
			UriComponentsBuilder uriBuilder) {
		Aluno aluno = alunoService.cadastrarAlunos(null, form.getNome(), form.getIdade(), form.getSerie());

		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}

	@GetMapping("/{id}")
	public AlunoDto consultarAluno(@PathVariable Long id) {
		Aluno aluno = alunoService.consultarAluno(id);

		return new AlunoDto(aluno);

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoDto> atualizarAluno(@PathVariable Long id, @RequestBody @Valid AtualizarAlunoForm form) {

		Aluno aluno = form.atualizar(id, alunoRepository);

		return ResponseEntity.ok(new AlunoDto(aluno));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerAluno(@PathVariable Long id) {
		alunoService.removerAluno(id);

		return ResponseEntity.ok().build();
	}

}
