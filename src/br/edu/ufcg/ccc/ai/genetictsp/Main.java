/*
 * Main.java
 *
 * Created on 29 de Outubro de 2006, 11:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp;

import br.edu.ufcg.ccc.ai.genetictsp.gui.MainFrame;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
}
