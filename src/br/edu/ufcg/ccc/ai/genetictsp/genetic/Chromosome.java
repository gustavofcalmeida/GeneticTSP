/*
 * Cromossomo.java
 *
 * Created on 13 de Novembro de 2006, 14:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.genetic;

import java.util.HashSet;
import java.util.Set;

import br.edu.ufcg.ccc.ai.genetictsp.utils.LogicalPoint2D;
import br.edu.ufcg.ccc.ai.genetictsp.utils.Randomizer;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class Chromosome implements Comparable<Chromosome> {
    
    private LogicalPoint2D[] cidades;
    
    /** Creates a new instance of Cromossomo */
    public Chromosome(LogicalPoint2D[] colecao) {
        
        this.cidades = colecao;        
    }
    
    private boolean mutacao(int porcentagem) {
        
        if (porcentagem <= 0) {
            return false;
        }
        
        int sorte = Randomizer.getInstance().getRandom().nextInt(100);
        
        if (sorte < porcentagem) {
            
            int index1 = Randomizer.getInstance().getRandom().nextInt(this.cidades.length);
            int index2 = Randomizer.getInstance().getRandom().nextInt(this.cidades.length);
            
            LogicalPoint2D aux = this.cidades[index1];
            this.cidades[index1] = this.cidades[index2];
            this.cidades[index2] = aux;
            
            return true;
        }
        
        return false;
    }
    
    public Chromosome[] cruzamento(Chromosome outro, int porcentagemCruzamento, int porcentagemMutacao) {
        
        Chromosome[] filhos = new Chromosome[2];
        
        if (porcentagemCruzamento <= 0) {
            
            filhos[0] = this.getClone();
            filhos[1] = outro.getClone();
        }
        else {
            
            int sorte = Randomizer.getInstance().getRandom().nextInt(100);
            
            if (sorte < porcentagemCruzamento) {
                
                int pontoCorte = Randomizer.getInstance().getRandom().nextInt(this.cidades.length - 2) + 1;

                Chromosome filho1 = this.getClone();
                Chromosome filho2 = outro.getClone();
                
                Set<LogicalPoint2D> set = new HashSet<LogicalPoint2D>(this.cidades.length - pontoCorte);
                
                for (int i = pontoCorte; i < this.cidades.length; i++) {
                    set.add(this.cidades[i]);
                }
                
                int indexSubstituto = pontoCorte;
                for (int i = 0; i < outro.cidades.length; i++) {
                    
                    if ( set.contains(outro.cidades[i]) ) {
                        
                        filho1.cidades[indexSubstituto] = outro.cidades[i];
                        indexSubstituto++;
                    }
                }
                
                set.clear();
                
                for (int i = pontoCorte; i < outro.cidades.length; i++) {
                    set.add(outro.cidades[i]);
                }
                
                indexSubstituto = pontoCorte;
                for (int i = 0; i < this.cidades.length; i++) {
                    
                    if ( set.contains(this.cidades[i]) ) {
                        
                        filho2.cidades[indexSubstituto] = this.cidades[i];
                        indexSubstituto++;
                    }
                }
                
//                System.out.println("Pais:");
//                System.out.println(this.toString());
//                System.out.println(outro.toString());
//                System.out.println("Filhos:");
//                System.out.println(filho1.toString());
//                System.out.println(filho2.toString());
//                System.out.println("Corte: " + pontoCorte);
                
                filhos[0] = filho1;
                filhos[1] = filho2;
            }
            else {
                
                filhos[0] = this.getClone();
                filhos[1] = outro.getClone();
            }
        }
        
        filhos[0].mutacao(porcentagemMutacao);
        filhos[1].mutacao(porcentagemMutacao);
        return filhos;
    }
    
    public Chromosome getClone() {
        
        return new Chromosome(this.cidades.clone());
    }

    public int compareTo(Chromosome outro) {
        
        return new Double(this.getCusto()).compareTo(outro.getCusto());
    }
    
    public double getCusto() {
        
        double custo = 0.0;
        
        for (int i = 0; i < this.cidades.length - 1; i++) {
            
            LogicalPoint2D p1 = this.cidades[i];
            LogicalPoint2D p2 = this.cidades[i + 1];
            
            custo += p1.getDistancia(p2);
        }
        LogicalPoint2D p1 = this.cidades[this.cidades.length - 1];
        LogicalPoint2D p2 = this.cidades[0];
        custo += p1.getDistancia(p2);
        
        return custo;
    }

    public LogicalPoint2D[] getCidades() {
                
        return (LogicalPoint2D[])this.cidades.clone();
    }
    
    public String toString() {
        
        StringBuilder sb = new StringBuilder("{ ");
        for (LogicalPoint2D p : this.cidades) {
            
            sb.append(p.getId() + " ");
        }
        
        sb.append("}");
        
        return sb.toString();
    }
}
