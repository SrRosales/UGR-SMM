/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p4_smm;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * Clase MiElipse que extiende Ellipse2D.Float para representar una elipse con la posibilidad de mover su ubicación.
 * Esta clase proporciona un método setLocation para mover la elipse a una nueva ubicación.
 * @author Alejandro Rosales Cantero
 */

public class MiElipse extends Ellipse2D.Float {

    /**
     * Constructor por defecto de la clase MiElipse.
     * Crea una elipse sin inicializar ninguna propiedad.
     */
    public MiElipse() {
    }

    /**
     * Constructor de la clase MiElipse que permite inicializar la elipse con dos puntos que definen su diagonal.
     * @param p1 Punto que representa una esquina de la diagonal de la elipse.
     * @param p2 Punto que representa la esquina opuesta de la diagonal de la elipse.
     */
    public MiElipse(Point2D p1, Point2D p2) {
        super.setFrameFromDiagonal(p1, p2);
    }

    /**
     * Método que mueve la elipse a una nueva ubicación especificada por un punto.
     * @param pos Punto que representa la nueva ubicación de la elipse.
     */
    public void setLocation(Point2D pos) {
        // Calcula la diferencia en coordenadas X y Y entre la posición actual del centro de la elipse y la nueva posición especificada
        double dx = pos.getX() - this.getCenterX();
        double dy = pos.getY() - this.getCenterY();

        // Actualiza la posición de la elipse sumando las diferencias calculadas a las coordenadas X e Y de su posición actual
        this.setFrame(this.getX() + dx, this.getY() + dy, this.getWidth(), this.getHeight());
    }
}
