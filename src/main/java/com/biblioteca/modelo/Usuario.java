package com.biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeferson
 *
 */

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@Column(name="CPF_USUARIO", nullable = false)
	private long cpf_usuario;
	private String nome;
	private String senha;
	
	
	/**
	 * @return the cpf_usuario
	 */
	public long getCpf_usuario() {
		return cpf_usuario;
	}
	/**
	 * @param cpf_usuario the cpf_usuario to set
	 */
	public void setCpf_usuario(long cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
