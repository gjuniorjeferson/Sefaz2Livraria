/**
 * 
 */
package com.biblioteca.controle;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
	
	private Livro livro;
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void novo() {
		livro = new Livro();
	}
	
	public void salvar() {
		try {
			Fachada.getInstancia().salvarNovolivro(livro);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Livro salvo com Sucesso!!!",null);
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, ("Não foi Possível concluir a operação: "+e.getMessage()),null);
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, message);		
		}
		
	}
}
