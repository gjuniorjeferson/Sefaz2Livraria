/**
 * 
 */
package com.biblioteca.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.biblioteca.fachada.Fachada;
import com.biblioteca.modelo.Livro;

/**
 * @author Jeferson
 *
 */

@ManagedBean(name="listaLivroBean")
@ViewScoped
public class ListaLivroBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Livro> livros;
	private Livro livro;
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public void novo() {
		livro = new Livro();
	}
	
	@PostConstruct //executa o metodo abaixo logo após carregar a janela
	public void listar() {
		try {
			livros = Fachada.getInstancia().listarTodosOsLivros();
		}
		catch (RuntimeException re) {
			re.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			//Fachada.getInstancia().salvarNovolivro(livro);
			Fachada.getInstancia().mergeLivro(livro);
			mostrarMensagemInfo("Salvo/Editado com sucesso");
			Livro livro = new Livro();
			livros = Fachada.getInstancia().listarTodosOsLivros();
		} catch (Exception e) {
			mostrarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir(ActionEvent event) {
		livro = (Livro) event.getComponent().getAttributes().get("livroSelecionado");
		try {
			Fachada.getInstancia().excluirLivro(livro);
			livros = Fachada.getInstancia().listarTodosOsLivros();
		}catch (RuntimeException re) {
			mostrarMensagemErro(re.getMessage());
			re.printStackTrace();
		}

		mostrarMensagemInfo("Excluido com sucesso!");
	}
	
	public void editar(ActionEvent event) {
		livro = (Livro) event.getComponent().getAttributes().get("livroSelecionado");
		try {
			Fachada.getInstancia().editarLivro(livro);
			livros = Fachada.getInstancia().listarTodosOsLivros();
		}catch (RuntimeException re) {
			re.printStackTrace();
		}

		mostrarMensagemInfo("Atualizado com sucesso");
		
	}
	
	private void mostrarMensagemInfo(String mensagem) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,null);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);	
	}
	
	private void mostrarMensagemErro(String mensagem) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem,null);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);	
	}
	
}
