/*
 * ParametroException.java
 *
 * Created on 8 de Novembro de 2006, 13:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.utils;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class ParameterException extends java.lang.Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>ParametroException</code> without detail message.
     */
    public ParameterException() {
    }
    
    
    /**
     * Constructs an instance of <code>ParametroException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ParameterException(String msg) {
        super(msg);
    }
}
