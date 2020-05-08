package com.biblioteca.dao.geral;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.biblioteca.dao.UsuarioDAO;
import com.biblioteca.modelo.*; //importar os modelos aqui

/**
 * @author Jeferson Junior
 *
 */

public abstract class DAOFactory {
	
	private static final EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("exemploPU"); //setar o nome do persistence-unit aqui
	}
	
	public static UsuarioDAO getUsuarioDAO(){
		UsuarioDAO  dao = new UsuarioDAO(factory);
		return dao;
	}
	
	
}

