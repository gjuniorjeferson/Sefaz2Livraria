package com.biblioteca.dao;

import javax.persistence.EntityManagerFactory;

import com.biblioteca.modelo.Usuario;
import com.biblioteca.dao.geral.DAOGenerico;

/**
 * @author Jeferson
 *
 */
public class UsuarioDAO extends DAOGenerico<Usuario> {
	
	public  UsuarioDAO(EntityManagerFactory emf) {
		super(emf);
	}
	
}
