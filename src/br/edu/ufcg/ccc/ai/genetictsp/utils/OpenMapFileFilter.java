/*
 * FiltroArquivos.java
 *
 * Created on 11 de Novembro de 2006, 11:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class OpenMapFileFilter extends FileFilter {
    
    /** Creates a new instance of FiltroArquivos */
    public OpenMapFileFilter() {
    }

    public boolean accept(File f) {
        
        if (f.isDirectory()) {
            
            return true;
        }
        
        return f.exists() && f.isFile() && f.canRead() && !f.isHidden() && f.getName().toLowerCase().endsWith(".tsm");
    }

    public String getDescription() {
        
        return java.util.ResourceBundle.getBundle("br/edu/ufcg/ccc/ai/genetictsp/gui/resources/local_strings").getString("OMFF_map_files");
    }
    
}
