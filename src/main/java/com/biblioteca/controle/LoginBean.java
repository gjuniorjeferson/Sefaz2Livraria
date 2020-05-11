/**
 * 
 */
package com.biblioteca.controle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.biblioteca.fachada.Fachada;
import com.biblioteca.modelo.Usuario;

/**
 * @author Jeferson
 *
 */

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {
	
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void novo() {
		usuario = new Usuario();
	}
	
	public void cadastrarNovoUsuario() {
		
		try {
			Fachada.getInstancia().salvarNovoUsuario(usuario);
			mostrarMensagemInfo("Usuario Salvo com sucesso");
		} catch (Exception e) {
			mostrarMensagemErro("Erro"+ e.getMessage());
			e.printStackTrace();
		}	
	}
	
	@PostConstruct
	public void initPage() {
		usuario = new Usuario();
	}
	
	public void login() {

		Usuario usuarioCadastrado = new Usuario();
		try {
			System.out.println("CPF informado: " + usuario.getCpf_usuario());
			usuarioCadastrado = Fachada.getInstancia().pesquisarUsuarioPorChave(usuario.getCpf_usuario());
			if (usuarioCadastrado.getSenha().equals(usuario.getSenha())) {
				System.out.println("login!!!");
				FacesContext.getCurrentInstance().getExternalContext().redirect("/Biblioteca/faces/listaLivro.xhtml");
			}
		} catch (Exception e) {
			System.out.println("Caiu na Exception");
			mostrarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
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
