package com.biblioteca.dao;

import javax.persistence.EntityManagerFactory;

import com.biblioteca.dao.geral.DAOGenerico;
import com.biblioteca.modelo.Livro;

public class LivroDAO extends DAOGenerico<Livro> {

	public LivroDAO(EntityManagerFactory emf)  {
		super(emf);
	}

}
