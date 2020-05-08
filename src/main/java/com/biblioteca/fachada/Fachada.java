package com.biblioteca.fachada;

import com.biblioteca.modelo.Usuario;
import com.biblioteca.modelo.rn.UsuarioRN;

/**
 * @author Jeferson
 *
 */

public class Fachada {
    private static Fachada instancia;
    private static UsuarioRN usuarioRN;
    
    private Fachada(){
    	usuarioRN = new UsuarioRN();  	
    }
    
    public static Fachada getInstancia(){
        if(instancia==null) instancia=new Fachada();
        return instancia;
    }

    /**
     * 
     * @param Objeto contendo os dados do Gerente
     * @throws Exception
     */
    public void salvarNovoUsuario(Usuario u)throws Exception{
    	usuarioRN.inserirNovo(u);
    }
   

}
