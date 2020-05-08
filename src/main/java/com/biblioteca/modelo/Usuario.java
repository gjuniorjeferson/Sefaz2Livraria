package com.biblioteca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

/**
 * @author Jeferson
 *
 */
@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	private long codigo_usuario;
	/**
	 * @return the codigo_usuario
	 */
	@Column(name="NOME_USUARIO", nullable = true)
	private String nome_usuario;
	@Column(name="SENHA_USUARIO", nullable = true)
	private String senha_usuario;
		
	/**
	 * @return the nome_usuario
	 */
	public String getNome_usuario() {
		return nome_usuario;
	}
	/**
	 * @param nome_usuario the nome_usuario to set
	 */
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	/**
	 * @return the senha_usuario
	 */
	public String getSenha_usuario() {
		return senha_usuario;
	}
	/**
	 * @param senha_usuario the senha_usuario to set
	 */
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	
	public long getCodigo_usuario() {
		return codigo_usuario;
	}
	/**
	 * @param codigo_usuario the codigo_usuario to set
	 */
	public void setCodigo_usuario(long codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

}
