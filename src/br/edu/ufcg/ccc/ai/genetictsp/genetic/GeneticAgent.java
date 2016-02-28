/*
 * AgenteGenetico.java
 *
 * Created on 13 de Novembro de 2006, 13:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.genetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.edu.ufcg.ccc.ai.genetictsp.utils.Point2DIF;
import br.edu.ufcg.ccc.ai.genetictsp.utils.LogicalPoint2D;
import br.edu.ufcg.ccc.ai.genetictsp.utils.Randomizer;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class GeneticAgent implements AgentIF {
    
    private ArrayList<Chromosome> populacao;
    private int[] acumulado;
    
    private int mutacoesOcorridas;
    private int cruzamentosOcorridos;
    
    int tamanhoPopulacao;
    int porcentagemMutacao;
    int porcentagemCruzamento;
    boolean elitismo;
    
    /** Creates a new instance of AgenteGenetico */
    public GeneticAgent(Collection<Point2DIF> cidades, int tamanhoPopulacao, int porcentagemMutacao, int porcentagemCruzamento, boolean elitismo) {
        
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.porcentagemMutacao = porcentagemMutacao;
        this.porcentagemCruzamento = porcentagemCruzamento;
        this.elitismo = elitismo;
        
        this.cruzamentosOcorridos = 0;
        this.mutacoesOcorridas = 0;
        
        List<LogicalPoint2D> listaCidades = new ArrayList<LogicalPoint2D>(cidades.size());
        int ids = 0;
        for (Point2DIF p : cidades) {
            
            listaCidades.add(new LogicalPoint2D(p.getX(), p.getY(), ++ids));
        }

        this.populacao = new ArrayList<Chromosome>(this.tamanhoPopulacao);
                
        for (int i = 0; i < this.tamanhoPopulacao; i++) {
            
            Collections.shuffle(listaCidades, Randomizer.getInstance().getRandom());
            
            this.populacao.add( new Chromosome(listaCidades.toArray(new LogicalPoint2D[listaCidades.size()])) );
        }
        
        Collections.sort(this.populacao);
        
        this.acumulado = new int[this.populacao.size()];
        this.acumulado[0] = this.populacao.size();
        
        for (int i = 1; i < this.acumulado.length; i++) {
            
            this.acumulado[i] = this.acumulado[i - 1] + this.populacao.size() - i;
        }
    }

    public Point2DIF[] realizaPasso() {
        
        Chromosome melhor = this.populacao.get(0).getClone();
        
        Chromosome[] pais = this.selecionaPais();
        Chromosome[] filhos = pais[0].cruzamento(pais[1], this.porcentagemCruzamento, this.porcentagemMutacao);

        this.populacao.remove(this.populacao.size() - 1);
        this.populacao.remove(this.populacao.size() - 1);

        this.insereOrdenado(filhos[0]);
        this.insereOrdenado(filhos[1]);
        
        if (this.tamanhoPopulacao != this.populacao.size()) {
            
            throw new IllegalArgumentException(java.util.ResourceBundle.getBundle("br/edu/ufcg/ccc/ai/genetictsp/gui/resources/local_strings").getString("GA_size_changed1"));
        }
        
        if ( this.elitismo && melhor.getCusto() < this.populacao.get(0).getCusto() ) {
            
            this.populacao.remove(this.populacao.size() - 1);
            this.insereOrdenado(melhor);            
            
            if (this.tamanhoPopulacao != this.populacao.size()) {
            
                throw new IllegalArgumentException(java.util.ResourceBundle.getBundle("br/edu/ufcg/ccc/ai/genetictsp/gui/resources/local_strings").getString("GA_size_changed2"));
            }
        }

        return this.populacao.get(0).getCidades();
    }

    public void resetaParametros(int tamanhoPopulacao, int porcentagemMutacao, int porcentagemCruzamento, boolean elitismo) {
        
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.porcentagemMutacao = porcentagemMutacao;
        this.porcentagemCruzamento = porcentagemCruzamento;
        this.elitismo = elitismo;
        
        this.cruzamentosOcorridos = 0;
        this.mutacoesOcorridas = 0;
                
        Point2DIF[] modeloCidades = this.populacao.get(0).getCidades();
        
        List<LogicalPoint2D> listaCidades = new ArrayList<LogicalPoint2D>(modeloCidades.length);
        int ids = 0;
        for (Point2DIF p : modeloCidades) {
            
            listaCidades.add(new LogicalPoint2D(p.getX(), p.getY(), ++ids));
        }

        this.populacao = new ArrayList<Chromosome>(this.tamanhoPopulacao);
        
        for (int i = 0; i < this.tamanhoPopulacao; i++) {
            
            Collections.shuffle(listaCidades, Randomizer.getInstance().getRandom());
            
            this.populacao.add( new Chromosome(listaCidades.toArray(new LogicalPoint2D[listaCidades.size()])) );
        }
        
        Collections.sort(this.populacao);
        
        this.acumulado = new int[this.populacao.size()];
        this.acumulado[0] = this.populacao.size();
        
        for (int i = 1; i < this.acumulado.length; i++) {
            
            this.acumulado[i] = this.acumulado[i - 1] + this.populacao.size() - i;
        }
    }

    public int getCruzamentos() {
        
        return this.cruzamentosOcorridos;
    }

    public int getMutacoes() {
        
        return this.mutacoesOcorridas;
    }

    public int getCustoSolucaoAtual() {
        
        return (int)this.populacao.get(0).getCusto();
    }    

    private Chromosome[] selecionaPais() {
        
        Chromosome[] pais = new Chromosome[2];
                       
        int index1 = Randomizer.getInstance().getRandom().nextInt(this.acumulado[this.acumulado.length - 1]);
        int index2 = Randomizer.getInstance().getRandom().nextInt(this.acumulado[this.acumulado.length - 1]);

        int i = 0;
        while (index1 >= this.acumulado[i]) {
            i++;
        }
        pais[0] = this.populacao.get(i);
        
        int j = 0;
        while (index2 >= this.acumulado[j]) {
            j++;
        }        
        if (i == j) {
            
            j = (i == this.populacao.size() - 1) ? (j - 1) : (j + 1);
        }        
        pais[1] = this.populacao.get(j);
        
        return pais;
    }

    private void insereOrdenado(Chromosome cromossomo) {
        
        int i = 0;
        while (i < this.populacao.size() && this.populacao.get(i).getCusto() <= cromossomo.getCusto()) {
            i++;
        }
        this.populacao.add(i, cromossomo);
    }
}
