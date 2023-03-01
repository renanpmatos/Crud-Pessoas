package com.challenge.api.service;

import java.util.List;
import java.util.Optional;

import com.challenge.api.model.Pessoa;

public interface PessoaService {
	List<Pessoa> pesquisarPessoas(String query);

	Pessoa criarPessoa(Pessoa pessoa);

	List<Pessoa> listaPessoas();

	Optional<Pessoa> deletaPessoa(Integer id);

	Pessoa alteraPessoa(Pessoa pessoa);

	Optional<Pessoa> pegaPessoa(Integer id);
}
