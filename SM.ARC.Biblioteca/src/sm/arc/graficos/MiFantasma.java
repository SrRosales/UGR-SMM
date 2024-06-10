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
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
/**
 * La clase MiFantasma representa un fantasma en un espacio gráfico. Extiende la
 * clase abstracta MiShape y proporciona implementaciones específicas para la
 * representación y manipulación de fantasmas.
 *
 * @author Alejandro Rosales Cantero
 */
public class MiFantasma extends MiShape {

    private Area fantasma; // El fantasma representado por la clase

    /**
     * Constructor de la clase MiFantasma.
     *
     * @param x La coordenada x de la posición inicial del fantasma
     * @param y La coordenada y de la posición inicial del fantasma
     */
    public MiFantasma(int x, int y) {
        // Crea las partes del fantasma y las une en un área
        crearFantasma(x, y);
    }

    /**
     * Obtiene el área que representa el fantasma.
     *
     * @return El área que representa el fantasma
     */
    public Area getFantasma() {
        return fantasma;
    }

    /**
     * Crea las partes del fantasma y las une en un área.
     *
     * @param x La coordenada x de la posición inicial del fantasma
     * @param y La coordenada y de la posición inicial del fantasma
     */
    public void crearFantasma(int x, int y) {
        // Cabeza del fantasma (una elipse)
        Ellipse2D.Float cabeza = new Ellipse2D.Float(x, y, 60, 60);
        Area areaCabeza = new Area(cabeza);

        // Calcular el ancho de la elipse de la cabeza
        float anchoCabeza = cabeza.width;

        // Cuerpo del fantasma
        Rectangle2D.Float cuerpo = new Rectangle2D.Float(x + (60 - anchoCabeza) / 2, y + 30, anchoCabeza, 60);
        Area areaCuerpo = new Area(cuerpo);

        // Ojos del fantasma (dos elipses pequeñas)
        Ellipse2D.Float ojoIzquierdo = new Ellipse2D.Float(x + 15, y + 20, 10, 10);
        Ellipse2D.Float ojoDerecho = new Ellipse2D.Float(x + 35, y + 20, 10, 10);
        Area areaOjoIzquierdo = new Area(ojoIzquierdo);
        Area areaOjoDerecho = new Area(ojoDerecho);

        // Combina las áreas para formar la forma del fantasma
        fantasma = areaCabeza;
        fantasma.add(areaCuerpo);
        fantasma.subtract(areaOjoIzquierdo);
        fantasma.subtract(areaOjoDerecho);
    }

    /**
     * Comprueba si un punto dado está contenido dentro del fantasma.
     *
     * @param p El punto a comprobar
     * @return true si el punto está contenido dentro del fantasma, false en
     * caso contrario
     */
    @Override
    public boolean contains(Point2D p) {
        // Si el fantasma es null, retornamos false ya que no hay fantasma para contener el punto
        if (fantasma == null) {
            return false;
        }
        // Si el fantasma no es null, verificamos si el punto p está dentro del fantasma
        return fantasma.contains(p);
    }

    /**
     * Mueve el fantasma a una nueva ubicación especificada por un punto.
     *
     * @param pos Punto que representa la nueva ubicación del fantasma.
     */
    @Override
    public void setLocation(Point2D pos) {
        // Si el fantasma es null, no hacemos nada ya que no hay fantasma para cambiar su ubicación
        if (fantasma == null) {
            return;
        }

        // Calcula la diferencia en coordenadas X y Y entre la posición actual del centro del fantasma y la nueva posición especificada
        double dx = pos.getX() - fantasma.getBounds2D().getCenterX();
        double dy = pos.getY() - fantasma.getBounds2D().getCenterY();

        // Crea una transformación de traslación con las diferencias calculadas
        AffineTransform at = AffineTransform.getTranslateInstance(dx, dy);

        // Aplica la transformación al fantasma
        fantasma.transform(at);
    }
    
    public Point2D getLocation() {
        // Si el fantasma es null, retornamos null ya que no hay fantasma para obtener su ubicación
        if (fantasma == null) {
            return null;
        }

        // Obtiene el rectángulo delimitador del fantasma
        Rectangle2D bounds = fantasma.getBounds2D();

        // Crea un punto que representa la ubicación de la esquina superior izquierda del fantasma
        Point2D location = new Point2D.Double(bounds.getX(), bounds.getY());

        return location;
    }

    /**
     * Dibuja el fantasma en el espacio gráfico proporcionado.
     *
     * @param g2d El contexto gráfico en el que se dibuja el fantasma
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

        // Verificar si el fantasma debe estar relleno o no
        if (isRelleno()) {
            g2d.fill(fantasma);
        } else {
            g2d.draw(fantasma);
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

            // Dibujar la elipse en la ubicación de la línea
            g2d.draw(new Ellipse2D.Double(ubicacion.getX(), ubicacion.getY(), 15, 15));

            // Restaurar el color y el trazo originales
            g2d.setColor(colorActual);
            g2d.setStroke(trazoActual);
        }
    }
}
