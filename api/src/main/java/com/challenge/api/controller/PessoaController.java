package com.challenge.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.api.model.Pessoa;
import com.challenge.api.service.PessoaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@GetMapping
	public List<Pessoa> listaPessoas () {
		return (List<Pessoa>) pessoaService.listaPessoas();
	}
	
	@GetMapping("/{id}")
	public Optional<Pessoa> pegaPessoa(@PathVariable Integer id){
		return pessoaService.pegaPessoa(id);
	}
	
	@GetMapping("/pesquisa")
	public ResponseEntity<List<Pessoa>> pesquisarPessoas(@RequestParam("query") String query){
		return ResponseEntity.ok(pessoaService.pesquisarPessoas(query));
	}
	
	@PostMapping
	public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.criarPessoa(pessoa);
	}
	
	@PutMapping
	public Pessoa alteraPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.alteraPessoa(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public Optional<Pessoa> deletaPessoa(@PathVariable Integer id) {
		return pessoaService.deletaPessoa(id);
	}
}
