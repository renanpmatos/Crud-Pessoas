package com.challenge.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.api.model.Pessoa;
import com.challenge.api.repository.PessoaRepository;
import com.challenge.api.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{

	private PessoaRepository pessoaRepository;
	
	public PessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public List<Pessoa> pesquisarPessoas(String query) {
		List<Pessoa> pessoas = pessoaRepository.pesquisarPessoas(query);
		return pessoas;
	}

	@Override
	public Optional<Pessoa> pegaPessoa(Integer id){
		Optional<Pessoa> idPessoa = pessoaRepository.findById(id);
		return idPessoa;
	}
	
	@Override
	public Pessoa criarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@Override
	public Pessoa alteraPessoa(Pessoa pessoa){
		Pessoa newPessoa = pessoaRepository.save(pessoa);
		return newPessoa;
	}
	
	@Override
	public List<Pessoa> listaPessoas() {
		return (List<Pessoa>) pessoaRepository.findAll();
	}

	@Override
	public Optional<Pessoa> deletaPessoa(Integer id) {
		Optional<Pessoa> oldPessoa = pessoaRepository.findById(id);
		pessoaRepository.deleteById(id);
		return oldPessoa;
	}

}
