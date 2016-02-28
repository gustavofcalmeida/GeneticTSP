/*
 * AgenteInterface.java
 *
 * Created on 29 de Outubro de 2006, 16:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.genetic;

import br.edu.ufcg.ccc.ai.genetictsp.utils.Point2DIF;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public interface AgentIF {
    
    Point2DIF[] realizaPasso();

    void resetaParametros(int tamanhoPopulacao, int porcentagemMutacao, int porcentagemCruzamento, boolean elitismo);

    int getCruzamentos();

    int getMutacoes();

    int getCustoSolucaoAtual();
}
