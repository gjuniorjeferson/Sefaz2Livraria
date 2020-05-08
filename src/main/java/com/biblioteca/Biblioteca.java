/**
 * 
 */
package com.biblioteca;

import com.biblioteca.dao.UsuarioDAO;
import com.biblioteca.dao.geral.DAOFactory;
import com.biblioteca.fachada.Fachada;
import com.biblioteca.modelo.Usuario;

/**
 * @author Jeferson
 *
 */
public class Biblioteca {
	
	
	public static void incluir() throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setCodigo_usuario(1001);
		usuario.setNome_usuario("jeferson");
		usuario.setSenha_usuario("12345");
		
		Fachada.getInstancia().salvarNovoUsuario(usuario);
		
	}
	
	

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		incluir();
		
	}

}
