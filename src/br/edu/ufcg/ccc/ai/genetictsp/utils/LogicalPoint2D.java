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
public class LogicalPoint2D implements Point2DIF {
    
    private Point p;
    private int id;
    
    /** Creates a new instance of Ponto2D */
    public LogicalPoint2D(Point p, int id) {
        this.p = p;
        this.id = id;
    }
    
    public LogicalPoint2D(int x, int y, int id) {
        this.p = new Point(x, y);
        this.id = id;
    }

    public int getX() {
        return p.x;
    }

    public int getY() {
        return p.y;
    }

    public int getId() {
        
        return this.id;
    }
    
    public boolean equals(Object obj) {
        
        return this.getId() == ((LogicalPoint2D)obj).getId();
    }
    
    public double getDistancia(LogicalPoint2D p2) {
        
        return this.p.distance(p2.p);
    }
    
    public int hashCode() {
        
        return this.getId();
    }
}
