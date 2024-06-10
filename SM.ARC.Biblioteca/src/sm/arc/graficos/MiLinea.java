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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * La clase MiLinea representa una línea en un espacio gráfico. Extiende la
 * clase abstracta MiShape y proporciona implementaciones específicas para la
 * representación y manipulación de líneas.
 *
 * @author Alejandro Rosales Cantero
 */
public class MiLinea extends MiShape {

    private Line2D.Float linea; // La línea representada por la clase

    /**
     * Constructor de la clase MiLinea.
     *
     * @param linea La línea que se va a representar
     */
    public MiLinea(Line2D.Float linea) {
        this.linea = linea;
    }

    /**
     * Obtiene la línea representada por esta instancia de MiLinea.
     *
     * @return La línea representada por esta instancia
     */
    public Line2D.Float getLinea() {
        return linea;
    }

    /**
     * Establece la línea que se va a representar.
     *
     * @param linea La nueva línea que se va a representar
     */
    public void setLinea(Line2D.Float linea) {
        this.linea = linea;
    }

    /**
     * Comprueba si un punto dado está contenido dentro de la línea.
     *
     * @param p El punto a comprobar
     * @return true si el punto está contenido dentro de la línea, false en caso
     * contrario
     */
    @Override
    public boolean contains(Point2D p) {
        // Define un umbral de distancia. Si un punto está a menos de esta distancia de la línea,
        // consideraremos que la línea "contiene" el punto.
        double umbralDeDistancia = 2.0;

        // Comprueba si el punto está lo suficientemente cerca de la línea
        return linea.ptLineDist(p) <= umbralDeDistancia;
    }

    /**
     * Mueve la línea a una nueva ubicación especificada por un punto.
     *
     * @param pos Punto que representa la nueva ubicación de la línea.
     */
    @Override
    public void setLocation(Point2D pos) {
        // Calcular la diferencia en x entre el segundo y el primer punto de la línea
        double dx = linea.getX2() - linea.getX1();

        // Calcular la diferencia en y entre el segundo y el primer punto de la línea
        double dy = linea.getY2() - linea.getY1();

        // Establecer una nueva línea que comienza en la posición especificada (pos)
        // y termina en un punto que está a una distancia dx, dy del punto de inicio
        linea.setLine(pos.getX(), pos.getY(), pos.getX() + dx, pos.getY() + dy);
    }

    public Point2D getLocation() {
        return linea.getP1();
    }
    
    /**
     * Dibuja la línea en el espacio gráfico proporcionado.
     *
     * @param g2d El contexto gráfico en el que se dibuja la línea
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

        // Dibujar la línea
        g2d.draw(linea);
        
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
