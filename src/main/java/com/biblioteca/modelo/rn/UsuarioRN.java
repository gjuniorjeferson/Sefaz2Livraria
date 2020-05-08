package com.biblioteca.modelo.rn;

import com.biblioteca.dao.UsuarioDAO;
import com.biblioteca.dao.geral.DAOFactory;
import com.biblioteca.modelo.Usuario;

public class UsuarioRN {
	
	private final UsuarioDAO usuarioDAO;
	
	public UsuarioRN(){
		usuarioDAO = DAOFactory.getUsuarioDAO();
	}
	
	/**
	 * @param com o objeto gerente
	 * 
	 */
	public void inserirNovo(Usuario g) throws Exception{
		usuarioDAO.insert(g);		
	}

	//Funções internas
	/*  
		public String validarCpf(Usuario objeto) throws Exception{
			if (objeto.getCpf() == null) {
				 throw new Exception("Cpf não pode ser Nulo");
			}else if (objeto.getCpf().isEmpty()) {
				throw new Exception("Cpf precisa ser preenchido");
			}
			return null;
		}
	
		private void validaPreenchimento(Usuario objeto) throws Exception {
			if (objeto.getNome() == null)
				throw new Exception("Nome nao pode ser nulo");
		}

		*/
}
