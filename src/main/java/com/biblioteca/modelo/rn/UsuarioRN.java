package com.biblioteca.modelo.rn;

import java.io.Serializable;

import com.biblioteca.dao.UsuarioDAO;
import com.biblioteca.dao.geral.DAOFactory;
import com.biblioteca.modelo.Usuario;

import java.util.List;

public class UsuarioRN {
	
	private final UsuarioDAO usuarioDAO;
	
	public UsuarioRN(){
		usuarioDAO = DAOFactory.getUsuarioDAO();
	}
	
	/**
	 * @param com o objeto Usuario
	 * 
	 */
	public void inserirNovo(Usuario u) throws Exception{
		//validarCpf(u);
		usuarioDAO.insert(u);		
	}
	
	public Usuario pesquisarUsuarioPorChave(Serializable chave) throws Exception{
		//validarCpf(u);
		return usuarioDAO.searchByKey(chave);		
	}
	
	/**
	 * Returna todos da tabela usuarios cadastrados no banco de dados
	 * @return List<Usuario> contendo todos os usuarios da tabela
	 */
	public List<Usuario> PesquisarTodosOsUsuarios(){
		
		return usuarioDAO.getAll();
	}
	
	//Funções internas
	 
	public void validarCpf(Usuario objeto) throws Exception {
		
		if (objeto.getCpf_usuario() == 0) 
			 throw new Exception("Cpf não pode ser Nulo");
		if (objeto.getCpf_usuario()+"".length() > 14) 
			throw new Exception("Cpf invalido");
	}

}
