/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * La clase MiElipse representa una elipse en un espacio gráfico. Extiende la
 * clase abstracta MiShape y proporciona implementaciones específicas para la
 * representación y manipulación de elipses.
 *
 * @author Alejandro Rosales Cantero
 */
public class MiElipse extends MiShape {

    private Ellipse2D.Float elipse; // La elipse representada por la clase

    /**
     * Constructor de la clase MiElipse.
     *
     * @param elipse La elipse que se va a representar
     */
    public MiElipse(Ellipse2D.Float elipse) {
        this.elipse = elipse;
    }

    /**
     * Obtiene la elipse representada por esta instancia de MiElipse.
     *
     * @return La elipse representada por esta instancia
     */
    public Ellipse2D.Float getElipse() {
        return elipse;
    }

    /**
     * Establece la elipse que se va a representar.
     *
     * @param elipse La nueva elipse que se va a representar
     */
    public void setElipse(Ellipse2D.Float elipse) {
        this.elipse = elipse;
    }

    /**
     * Comprueba si un punto dado está contenido dentro de la elipse.
     *
     * @param p El punto a comprobar
     * @return true si el punto está contenido dentro de la elipse, false en
     * caso contrario
     */
    @Override
    public boolean contains(Point2D p) {
        // Si la elipse es null, retornamos false ya que no hay elipse para contener el punto
        if (elipse == null) {
            return false;
        }
        // Si la elipse no es null, verificamos si el punto p está dentro de la elipse
        return elipse.contains(p);
    }

    /**
     * Mueve la elipse a una nueva ubicación especificada por un punto.
     *
     * @param pos Punto que representa la nueva ubicación de la elipse.
     */
    @Override
    public void setLocation(Point2D pos) {
        // Si la elipse es null, no hacemos nada ya que no hay elipse para cambiar su ubicación
        if (elipse == null) {
            return;
        }

        // Calcula la diferencia en coordenadas X y Y entre la posición actual del centro de la elipse y la nueva posición especificada
        double dx = pos.getX() - elipse.getCenterX();
        double dy = pos.getY() - elipse.getCenterY();

        // Actualiza la posición de la elipse sumando las diferencias calculadas a las coordenadas X e Y de su posición actual
        elipse.setFrame(elipse.getX() + dx, elipse.getY() + dy, elipse.getWidth(), elipse.getHeight());
    }
    
    public Point2D getLocation() {
        return new Point2D.Float((float) elipse.getCenterX(), (float) elipse.getCenterY());
    }

    /**
     * Dibuja la elipse en el espacio gráfico proporcionado.
     *
     * @param g2d El contexto gráfico en el que se dibuja la elipse
     */
    @Override
    public void draw(Graphics2D g2d) {
        // Asignar el color de las figuras
        g2d.setColor(getColor());

        // Asignar el grosor del trazo
        g2d.setStroke(getGrosor());

        // Verificar si el alisado está activado
        if (isAlisado()) {
            // Activar el alisado
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            // Desactivar el alisado
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }

        // Verificar si la transparencia está activada
        if (isTransparencia()) {
            // Aplicar una transparencia (alfa) de 0.5
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        } else {
            // Restaurar la transparencia predeterminada (sin transparencia)
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }

        // Verificar si la elipse debe estar rellena o no
        if (isRelleno()) {
            g2d.fill(elipse);
        } else {
            g2d.draw(elipse);
        }
        
        if(isSeleccionado()){
            // Guardar el color y el trazo actuales
            Color colorActual = g2d.getColor();
            Stroke trazoActual = g2d.getStroke();

            // Establecer el color rojo para la elipse
            g2d.setColor(Color.RED);

            // Establecer el grosor del trazo
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 3));
            
            // Obtener la ubicación de la elipse
            Point2D ubicacion = getLocation();

            // Dibujar la elipse en la ubicación de la elipse
            g2d.draw(new Ellipse2D.Double(ubicacion.getX(), ubicacion.getY(), 15, 15));

            // Restaurar el color y el trazo originales
            g2d.setColor(colorActual);
            g2d.setStroke(trazoActual);
        }
    }
}
