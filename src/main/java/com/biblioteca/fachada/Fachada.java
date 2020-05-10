package com.biblioteca.fachada;

import java.io.Serializable;
import java.util.List;

import com.biblioteca.modelo.Livro;
import com.biblioteca.modelo.Usuario;
import com.biblioteca.modelo.rn.LivroRN;
import com.biblioteca.modelo.rn.UsuarioRN;

/**
 * @author Jeferson
 *
 */

public class Fachada {
    private static Fachada instancia;
    private static UsuarioRN usuarioRN;
    private static LivroRN livroRN;
    
    private Fachada(){
    	usuarioRN = new UsuarioRN();
    	livroRN = new LivroRN(); 
    }
    
    public static Fachada getInstancia(){
        if(instancia==null) instancia=new Fachada();
        return instancia;
    }

    /**
     * Salva um novo usuario no banco de dados
     * @param Usuario Objeto contendo os dados do usuario
     * @throws Exception
     */
    public void salvarNovoUsuario(Usuario u)throws Exception{
    	usuarioRN.inserirNovo(u);
    }
    
    /**
     * Pesquisar usuario por chave
     * @param chave do usuario
     * @return Usuario
     * @throws Exception
     */
    public Usuario pesquisarUsuarioPorChave(Serializable chave) throws Exception {
    	return usuarioRN.pesquisarUsuarioPorChave(chave);	
    }
    
    /**
     *  Retorna todos os usuarios cadastrados no banco de dados
     * @return List<Usuario> Contendo todos os dados da tabela Usuario
     */
    
    public List<Usuario> pesquisarTodosOsUsuarios(){
    	return usuarioRN.PesquisarTodosOsUsuarios(); 	
    }
    
	/* Livro */
    
    /**
     * Salva um novo Livro no banco de dados
     * @param Livro contendo os dados do Livro 
     * @throws Exception
     */
    public void salvarNovolivro(Livro livro)throws Exception{
    	livroRN.inserirNovo(livro);
    }
    
	/**
	 * Consultar todos os livros do banco de dados
	 * @return List<Livro> Lista contendo todos os dados da tabela livro
	 */
    public List<Livro> listarTodosOsLivros(){
    	return livroRN.listarTodosOsLivros();
    }
    
    /***
     * Excluir livro da base de dados
     * @param livro a ser excluido
     */
    
    public void excluirLivro(Livro livro) {
    	livroRN.excluir(livro);
    }
    
}
