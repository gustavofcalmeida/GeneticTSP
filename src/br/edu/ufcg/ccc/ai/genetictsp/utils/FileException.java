/*
 * ArquivoException.java
 *
 * Created on 11 de Novembro de 2006, 15:55
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
public class FileException extends java.lang.Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of <code>ArquivoException</code> without detail message.
     */
    public FileException() {
    }
    
    
    /**
     * Constructs an instance of <code>ArquivoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FileException(String msg) {
        super(msg);
    }
}
