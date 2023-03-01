package com.challenge.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	 
	// pesquisa no objeto
	@Query("SELECT p FROM Pessoa p WHERE "
			+ "p.nome LIKE CONCAT('%',:query, '%')")
	List<Pessoa> pesquisarPessoas(String query);
	
	// pesquisa no SQL
	@Query(value = "SELECT * FROM pessoas p WHERE "
			+ "p.nome LIKE CONCAT('%',:query, '%')", nativeQuery = true)
	List<Pessoa> pesquisarPessoasSQL(String query);
	
}
