/*
 * Radomizador.java
 *
 * Created on 13 de Novembro de 2006, 15:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.utils;

import java.util.Random;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class Randomizer {
    
    private static Randomizer randomizador;
    private Random r;
    // TODO por ser único, esse randomizador causa correlação
    public static Randomizer getInstance() {
        
        if (randomizador == null) {
            
            randomizador = new Randomizer();
        }
        
        return randomizador;
    }
    
    private Randomizer() {
        
        this.r = new Random(System.currentTimeMillis());
    }
    
    public double random() {
        
        return this.r.nextDouble();
    }
    
    public Random getRandom() {
        
        return this.r;
    }
}
