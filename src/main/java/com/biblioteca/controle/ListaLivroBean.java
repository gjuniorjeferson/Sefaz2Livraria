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

@SuppressWarnings("serial")
@ManagedBean(name="listaLivroBean")
@ViewScoped
public class ListaLivroBean implements Serializable{
	
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
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro ao consultar livros da base de dados"+re.getMessage(),null);
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);
			re.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			Fachada.getInstancia().salvarNovolivro(livro);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro salvo com Sucesso!!!","testeeeeee");
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);
			Livro livro = new Livro();
			livros = Fachada.getInstancia().listarTodosOsLivros();
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ("Não foi Possível concluir a operação: "+e.getMessage()),null);
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);		
		}
		
	}
	
	public void excluir(ActionEvent event) {
		livro = (Livro) event.getComponent().getAttributes().get("livroSelecionado");
		try {
			Fachada.getInstancia().excluirLivro(livro);
			livros = Fachada.getInstancia().listarTodosOsLivros();
		}catch (RuntimeException re) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possível concluir a solicitação: " + re.getMessage(),null);
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);	
			re.printStackTrace();
		}

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Excluido com sucesso",null);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);		
	}
}
