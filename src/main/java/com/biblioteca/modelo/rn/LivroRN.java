/**
 * 
 */
package com.biblioteca.modelo.rn;

import java.util.List;

import com.biblioteca.dao.LivroDAO;
import com.biblioteca.dao.geral.DAOFactory;
import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Usuario;

/**
 * @author Jeferson
 *
 */
public class LivroRN {
	private final LivroDAO livroDAO;
	/**
	 * 
	 */
	public LivroRN() {
		livroDAO = DAOFactory.getLivroDAO();
	}
	
	public void inserirNovo(Livro l) throws Exception{
		validarCampos(l);
		livroDAO.insert(l);		
	}
	
	public void mergeLivro(Livro livro) {
		livroDAO.update(livro);
	}

	public List<Livro> listarTodosOsLivros(){
		return livroDAO.getAll();
	}
	
	public void excluir(Livro livro) {
		livroDAO.remove(livro);
	}
	
	public void editarLivro(Livro livro) {
		livroDAO.refresh(livro);
	}
	
	public void validarCampos(Livro livro) throws Exception{
		if(livro == null)
			throw new Exception("Objeto livro não pode ser Nulo");
		if(livro.getTitulo().equals(""))
			throw new Exception("Titulo Inválido");
	}
	
}
