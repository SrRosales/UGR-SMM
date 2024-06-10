/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * La clase abstracta MiShape representa una forma básica en un espacio gráfico.
 * Las formas pueden tener propiedades como color, grosor del trazo, relleno,
 * transparencia y alisado. Las clases concretas deben implementar los métodos
 * abstractos definidos aquí.
 *
 * @author Alejandro Rosales Cantero
 */
public abstract class MiShape {

    private Color color; // Color de la forma
    private Stroke grosor = new BasicStroke(); // Grosor del trazo
    private boolean relleno = false; // Indica si la forma está rellena
    private boolean transparencia = false; // Indica si la transparencia está activada
    private boolean alisado = false; // Indica si el alisado está activado
    private boolean seleccionado = false;

    /**
     * Obtiene el color de la forma.
     *
     * @return El color de la forma
     */
    public Color getColor() {
        return color;
    }

    /**
     * Obtiene el grosor del trazo.
     *
     * @return El grosor del trazo
     */
    public Stroke getGrosor() {
        return grosor;
    }

    /**
     * Comprueba si la forma está rellena.
     *
     * @return true si la forma está rellena, false en caso contrario
     */
    public boolean isRelleno() {
        return relleno;
    }

    /**
     * Comprueba si la transparencia está activada.
     *
     * @return true si la transparencia está activada, false en caso contrario
     */
    public boolean isTransparencia() {
        return transparencia;
    }

    /**
     * Comprueba si el alisado está activado.
     *
     * @return true si el alisado está activado, false en caso contrario
     */
    public boolean isAlisado() {
        return alisado;
    }
    
    /**
     * Comprueba si el seleccionado está activado.
     *
     * @return true si el seleccionado está activado, false en caso contrario
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * Establece el color de la forma.
     *
     * @param color El nuevo color de la forma
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Establece el grosor del trazo.
     *
     * @param grosor El nuevo grosor del trazo
     */
    public void setGrosor(Stroke grosor) {
        this.grosor = grosor;
    }

    /**
     * Establece si la forma debe estar rellena o no.
     *
     * @param relleno true para rellenar la forma, false para no rellenarla
     */
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    /**
     * Establece si la transparencia está activada o no.
     *
     * @param transparencia true para activar la transparencia, false para
     * desactivarla
     */
    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }

    /**
     * Establece si el alisado está activado o no.
     *
     * @param alisado true para activar el alisado, false para desactivarlo
     */
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }

    /**
     * Establece si el seleccionado está activado o no.
     *
     * @param seleccionado true para activar el seleccionado, false para desactivarlo
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * Comprueba si un punto dado está contenido dentro de la forma.
     *
     * @param p El punto a comprobar
     * @return true si el punto está contenido dentro de la forma, false en caso
     * contrario
     */
    public abstract boolean contains(Point2D p);

    /**
     * Establece la posición de la forma en el espacio gráfico.
     *
     * @param pos La nueva posición de la forma
     */
    abstract public void setLocation(Point2D pos);
    
    /**
     * Devuelve la posición de la forma en el espacio gráfico.
     */
    abstract public Point2D getLocation();

    /**
     * Dibuja la forma en el espacio gráfico proporcionado.
     *
     * @param g2d El contexto gráfico en el que se dibuja la forma
     */
    public abstract void draw(Graphics2D g2d);
}
