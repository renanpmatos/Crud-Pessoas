package com.challenge.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;
	
	@Column(name = "nome", length = 50, nullable = true)
	private String nome;
	
	@Column(name = "email", length = 50, nullable = true)
	private String email;
	
	@Column(name = "tipo", length = 50, nullable = true)
	private String tipo;
	
	@Column(name = "cpf", length = 50)
	private String cpf;	
	
	@Column(name = "cnpj", length = 50)
	private String cnpj;
	
	@Column(name = "cep", length = 10, nullable = true)
	private String cep;
	
	@Column(name = "endereco", length = 255)
	private String endereco;
	
	@Column(name = "logradouro", length = 255)
	private String logradouro;
	
	@Column(name = "bairro", length = 255)
	private String bairro;
	
	@Column(name = "cidade", length = 255)
	private String cidade;
	
	@Column(name = "estado", length = 255)
	private String estado;
	

	// get - set: id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	// get - set: nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	// get - set: email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// get - set: tipo
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// get - set: cpf
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf==null || cpf==""){
			this.cpf=null;
		}
		else{
			this.cpf = cpf;	
		}
	}

	// get - set: cnpj
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		if(cnpj==null || cnpj==""){
			this.cnpj=null;
		}
		else {
			this.cnpj = cnpj;	
		}
	}

	// get - set: cep
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	// get - set: endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	// get - set: logradouro
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	// get - set: bairro
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	// get - set: cidade
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	// get - set: estado
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}