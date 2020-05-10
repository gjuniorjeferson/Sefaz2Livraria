/**
 * 
 */
package com.biblioteca;

import com.biblioteca.fachada.Fachada;
import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Usuario;

/**
 * @author Jeferson
 *
 */
public class Biblioteca {
	
	
	public static void incluir() throws Exception {
		/* 
		Usuario usuario = new Usuario();
		usuario.setCpf_usuario(56656);
		usuario.setNome("junior");
		usuario.setSenha("123453");
		
		Fachada.getInstancia().salvarNovoUsuario(usuario);
		 */
		Livro livro = new Livro();
		livro.setTitulo("Programando Java");
		livro.setAutor("Deitel");
		livro.setCategoria("Programação");
		Fachada.getInstancia().salvarNovolivro(livro); 
		
	}
	
	public static void pesquisarPorChave() throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setCpf_usuario(4545454);
		usuario.setSenha("12345");
		System.out.println("Teste pesquisa do usuario, pesquisa por chave e imprime nome: " + 
		Fachada.getInstancia().pesquisarUsuarioPorChave(usuario.getCpf_usuario()).getNome());

	}
	
	public static void pesquisarTodos() throws Exception {
		System.out.println("Imrpimindo todos os objetos da tabela usuario: " + Fachada.getInstancia().pesquisarTodosOsUsuarios());
		
	}
	
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		incluir();
		//pesquisar();
		
		//pesquisarTodos();
	}

}
