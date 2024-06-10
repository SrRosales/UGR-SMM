/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * La clase MiRectangulo representa un rectángulo en un espacio gráfico.
 * Extiende la clase abstracta MiShape y proporciona implementaciones
 * específicas para la representación y manipulación de rectángulos.
 *
 * @author Alejandro Rosales Cantero
 */
public class MiRectangulo extends MiShape {

    private Rectangle2D.Float rectangulo; // El rectángulo representado por la clase

    /**
     * Constructor de la clase MiRectangulo.
     *
     * @param rectangulo El rectángulo que se va a representar
     */
    public MiRectangulo(Rectangle2D.Float rectangulo) {
        this.rectangulo = rectangulo;
    }

    /**
     * Obtiene el rectángulo representado por esta instancia de MiRectangulo.
     *
     * @return El rectángulo representado por esta instancia
     */
    public Rectangle2D.Float getRectangulo() {
        return rectangulo;
    }

    /**
     * Establece el rectángulo que se va a representar.
     *
     * @param rectangulo El nuevo rectángulo que se va a representar
     */
    public void setRectangulo(Rectangle2D.Float rectangulo) {
        this.rectangulo = rectangulo;
    }

    /**
     * Comprueba si un punto dado está contenido dentro del rectángulo.
     *
     * @param p El punto a comprobar
     * @return true si el punto está contenido dentro del rectángulo, false en
     * caso contrario
     */
    @Override
    public boolean contains(Point2D p) {
        // Si el rectángulo es null, retornamos false ya que no hay rectángulo para contener el punto
        if (rectangulo == null) {
            return false;
        }
        // Si el rectángulo no es null, verificamos si el punto p está dentro del rectángulo
        return rectangulo.contains(p);
    }

    /**
     * Mueve el rectángulo a una nueva ubicación especificada por un punto.
     *
     * @param pos Punto que representa la nueva ubicación del rectángulo.
     */
    @Override
    public void setLocation(Point2D pos) {
        // Si el rectángulo es null, no hacemos nada ya que no hay rectángulo para cambiar su ubicación
        if (rectangulo == null) {
            return;
        }

        // Calcula la diferencia en coordenadas X y Y entre la posición actual del centro del rectángulo y la nueva posición especificada
        double dx = pos.getX() - rectangulo.getCenterX();
        double dy = pos.getY() - rectangulo.getCenterY();

        // Actualiza la posición del rectángulo sumando las diferencias calculadas a las coordenadas X e Y de su posición actual
        rectangulo.setFrame(rectangulo.getX() + dx, rectangulo.getY() + dy, rectangulo.getWidth(), rectangulo.getHeight());
    }
    
    public Point2D getLocation() {
        return new Point2D.Float(rectangulo.x, rectangulo.y);
    }

    /**
     * Dibuja el rectángulo en el espacio gráfico proporcionado.
     *
     * @param g2d El contexto gráfico en el que se dibuja el rectángulo
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
        
        // Verificar si el rectángulo debe estar relleno o no
        if (isRelleno()) {
            g2d.fill(rectangulo);
        } else {
            g2d.draw(rectangulo);
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
            
            // Obtener la ubicación de la línea
            Point2D ubicacion = getLocation();
            
            // Dibujar la elipse en la ubicación del rectángulo
            g2d.draw(new Ellipse2D.Double(ubicacion.getX(), ubicacion.getY(), 15, 15));
            
            // Restaurar el color y el trazo originales
            g2d.setColor(colorActual);
            g2d.setStroke(trazoActual);
        }
    }
}
