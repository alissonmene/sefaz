package br.com.ivia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="usuario")
@Entity	
public class Usuario extends Entidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7643145066145507844L;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "senha")
	private String senha;


	@Column(unique = true, name = "email")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Telefone> telefones;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
