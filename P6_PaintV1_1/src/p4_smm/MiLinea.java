/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p4_smm;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Clase MiLinea que extiende Line2D.Float para representar una línea con la posibilidad de mover su ubicación.
 * Esta clase proporciona un método setLocation para mover la línea a una nueva ubicación.
 * @author Alejandro Rosales Cantero
 */
public class MiLinea extends Line2D.Float {

    /**
     * Constructor de la clase MiLinea que permite inicializar la línea con dos puntos que definen sus extremos.
     * @param p1 Punto que representa el primer extremo de la línea.
     * @param p2 Punto que representa el segundo extremo de la línea.
     */
    public MiLinea(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    /**
     * Método que verifica si un punto está cerca de la línea.
     * @param p Punto que se va a verificar si está cerca de la línea.
     * @return true si el punto está cerca de la línea, false en caso contrario.
     */
    public boolean isNear(Point2D p) {
        if (this.getP1().equals(this.getP2())) {
            return this.getP1().distance(p) <= 2.0; // p1 = p2
        }
        return this.ptLineDist(p) <= 2.0; // p1 != p2
    }

    /**
     * Método que verifica si un punto está contenido dentro de la línea.
     * @param p Punto que se va a verificar si está contenido dentro de la línea.
     * @return true si el punto está contenido dentro de la línea, false en caso contrario.
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
    
    /**
     * Método que mueve la línea a una nueva ubicación especificada por un punto.
     * @param pos Punto que representa la nueva ubicación de la línea.
     */
    public void setLocation(Point2D pos) {
        // Calcula la diferencia en coordenadas X y Y entre la posición actual del primer extremo de la línea y la nueva posición especificada
        double dx = pos.getX() - this.getX1();
        double dy = pos.getY() - this.getY1();
        
        // Calcula la nueva posición del segundo extremo de la línea al sumar las diferencias calculadas a las coordenadas X e Y de su posición actual
        Point2D newp2 = new Point2D.Double(this.getX2() + dx, this.getY2() + dy);
        
        // Establece la línea con los nuevos puntos calculados
        this.setLine(pos, newp2);
    }
}

