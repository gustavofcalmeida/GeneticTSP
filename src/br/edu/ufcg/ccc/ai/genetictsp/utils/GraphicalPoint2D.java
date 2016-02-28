/*
 * Ponto2D.java
 *
 * Created on 29 de Outubro de 2006, 17:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.ufcg.ccc.ai.genetictsp.utils;

import java.awt.Point;

/**
 *
 * @author Gustavo de Farias
 * @author Diego Renato
 * @author Helder Fernando
 */
public class GraphicalPoint2D implements Point2DIF {
    
    private Point p;
    
    /** Creates a new instance of Ponto2D */
    public GraphicalPoint2D(Point p) {
        this.p = p;
    }
    
    public GraphicalPoint2D(int x, int y) {
        this.p = new Point(x, y);
    }

    public int getX() {
        return p.x;
    }

    public int getY() {
        return p.y;
    }
    
}
