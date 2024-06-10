/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package sm.arc.iu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import sm.arc.graficos.MiShape;
import sm.arc.graficos.MiLinea;
import sm.arc.graficos.MiElipse;
import sm.arc.graficos.MiRectangulo;
import sm.arc.graficos.MiFantasma;

/**
 * La clase Lienzo2D representa un lienzo gráfico donde se pueden dibujar y
 * manipular formas. Extiende javax.swing.JPanel y proporciona funcionalidades
 * para dibujar formas, seleccionarlas, moverlas, etc.
 *
 * @author Alejandro Rosales Cantero
 */
public class Lienzo2D extends javax.swing.JPanel {

    // Variable que representa la forma actual que se está dibujando en el lienzo
    private MiShape forma;

    // Variable que almacena el color actual para dibujar en el lienzo
    private Color color = Color.BLACK;

    // Variable que indica si se debe rellenar la forma dibujada en el lienzo
    private boolean relleno = false;

    // Enumeración que define los tipos de formas disponibles para dibujar en el lienzo
    public enum tipoOpcion {
        LINEA, RECTANGULO, ELIPSE, FANTASMA
    };

    // Tipo de forma seleccionada por defecto
    tipoOpcion tipoforma = null;

    // Variable que almacena el punto inicial de la forma dibujada
    private Point punto;

    // Variable que almacena el punto anclaje para mover la figura
    private Point puntoAnclaje;

    // Variable que indica si el modo mover está activado o desactivado
    private boolean mover = false;

    // Lista que almacena todas las formas dibujadas en el lienzo
    List<MiShape> listaFiguras = new ArrayList();

    // Variable que define el grosor del trazo para las formas dibujadas
    private int Grosor;

    // Variable que indica si el alisado de las formas está activado o desactivado
    private Boolean alisado = false;

    // Variable que indica si la transparencia de las formas está activada o desactivada
    private boolean transparencia = false;
    
    // Variable que almacenará una imagen
    BufferedImage img;
    
    // Variable para indicar si esta seleccionado o no una figura
    private boolean seleccionado = false;
    
    // Variable para indicar si se usa el volcado o no
    private boolean volcado = true;

    // Métodos getter y setter para las variables de instancia
    /**
     * Obtiene la forma actual que se está dibujando en el lienzo.
     *
     * @return La forma actual que se está dibujando
     */
    public MiShape getForma() {
        return forma;
    }

    /**
     * Establece la forma actual que se está dibujando en el lienzo.
     *
     * @param forma La forma a establecer como forma actual
     */
    public void setForma(MiShape forma) {
        this.forma = forma;
    }

    /**
     * Obtiene el color actual para dibujar en el lienzo.
     *
     * @return El color actual para dibujar
     */
    public Color getColor() {
        return color;
    }

    /**
     * Establece el color actual para dibujar en el lienzo.
     *
     * @param color El color a establecer como color actual
     */
    public void setColor(Color color) {
        this.color = color;
        if(isSeleccionado()){
            forma.setColor(color);
        }
        this.repaint();
    }

    /**
     * Comprueba si se debe rellenar la forma dibujada en el lienzo.
     *
     * @return true si se debe rellenar la forma, false en caso contrario
     */
    public boolean isRelleno() {
        return relleno;
    }

    /**
     * Establece si se debe rellenar la forma dibujada en el lienzo.
     *
     * @param relleno true para rellenar la forma, false para dibujar solo el
     * contorno
     */
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
        if(isSeleccionado()){
            forma.setRelleno(true);
        }
        this.repaint();
    }

    /**
     * Obtiene el tipo de forma seleccionado.
     *
     * @return El tipo de forma seleccionado
     */
    public tipoOpcion getTipoforma() {
        return tipoforma;
    }

    /**
     * Establece el tipo de forma seleccionado.
     *
     * @param tipoforma El tipo de forma a seleccionar
     */
    public void setTipoforma(tipoOpcion tipoforma) {
        this.tipoforma = tipoforma;
    }

    /**
     * Comprueba si el modo mover está activado.
     *
     * @return true si el modo mover está activado, false en caso contrario
     */
    public boolean isMover() {
        return mover;
    }

    /**
     * Establece si el modo mover está activado.
     *
     * @param mover true para activar el modo mover, false para desactivarlo
     */
    public void setMover(boolean mover) {
        this.mover = mover;
    }

    /**
     * Obtiene si el alisado de las formas está activado.
     *
     * @return true si el alisado está activado, false en caso contrario
     */
    public Boolean getAlisado() {
        return alisado;
    }

    /**
     * Establece si el alisado de las formas está activado.
     *
     * @param alisado true para activar el alisado, false para desactivarlo
     */
    public void setAlisado(Boolean alisado) {
        this.alisado = alisado;
        if(isSeleccionado()){
            forma.setAlisado(true);
        }
        this.repaint();
    }

    /**
     * Comprueba si la transparencia de las formas está activada.
     *
     * @return true si la transparencia está activada, false en caso contrario
     */
    public boolean isTransparencia() {
        return transparencia;
    }

    /**
     * Establece si la transparencia de las formas está activada.
     *
     * @param transparencia true para activar la transparencia, false para
     * desactivarla
     */
    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
        if(isSeleccionado()){
            forma.setTransparencia(true);
        }
        this.repaint();
    }

    /**
     * Obtiene el grosor del trazo para las formas dibujadas.
     *
     * @return El grosor del trazo
     */
    public int getGrosor() {
        return Grosor;
    }

    /**
     * Establece el grosor del trazo para las formas dibujadas.
     *
     * @param Grosor El grosor del trazo a establecer
     */
    public void setGrosor(int Grosor) {
        this.Grosor = Grosor;
        if(isSeleccionado()){
            forma.setGrosor(new BasicStroke(Grosor));
        }
        this.repaint();
    }
    
    /**
     * Establece la imagen
     *
     * @param img La imagen
     */
    public void setImage(BufferedImage img) {
        this.img = img;
        if (img != null) {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        }
    }


    /**
     * Obtiene la imagen
     *
     * @return La imagen
     */
    public BufferedImage getImage() {
        return img;
    }

    /**
     * Devuelve el valor del campo 'seleccionado'.
     *
     * @return true si el elemento está seleccionado, false en caso contrario.
     */
    public boolean isSeleccionado() {
        return seleccionado;
    }

    /**
     * Establece el valor del campo 'seleccionado'.
     *
     * @param seleccionado un booleano que indica si el elemento está
     * seleccionado.
     */
    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    /**
     * Devuelve la lista de objetos MiShape.
     *
     * @return una lista que contiene objetos MiShape.
     */
    public List<MiShape> getListaFiguras() {
        return listaFiguras;
    }

    /**
     * Establece el valor del campo 'volcado'.
     *
     * @param volcado un booleano que indica si el elemento está volcado.
     */
    public void setVolcado(boolean volcado) {
        this.volcado = volcado;
    }

    
    /**
     * Constructor de la clase Lienzo2D.
     */
    public Lienzo2D() {
        initComponents();
    }

    /**
     * Método que se encarga de dibujar las formas en el lienzo.
     *
     * @param g El contexto gráfico en el que se dibujan las formas
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if(img!=null) g2d.drawImage(img,0,0,this);
        for (MiShape s : listaFiguras) {
            s.draw(g2d);
        }
    }

    /**
     * Método que devuelve la forma seleccionada en el punto dado.
     *
     * @param p El punto en el que se busca la forma seleccionada
     * @return La forma seleccion
     */
    private MiShape figuraSeleccionada(Point2D p) {
        for (MiShape s : listaFiguras) {
            if (s.contains(p)) {
                return s;
            }
        }
        return null;
    }
    

    public BufferedImage getPaintedImage() {
        //crearemos una nueva imagen del mismo tamaño y tipo que la original
        BufferedImage imgout = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());

        //creamos el graphics asociado a la imagen apra poder pintar sobre ella
        Graphics2D g2dImagen = imgout.createGraphics();

            //usar g2dimagen para pintar la imagen de fondo, y las distintaas formas del vector
            if (img != null) {
                g2dImagen.drawImage(img, 0, 0, this);
            }
            for (MiShape s : listaFiguras) {
                s.draw(g2dImagen);
            }
        return imgout;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Este método se ejecuta cuando se presiona el botón del mouse en el
     * lienzo. Si el modo mover está activado, selecciona la forma en el punto
     * de clic y guarda el punto de anclaje. Si no está en modo mover, crea una
     * nueva forma según el tipo seleccionado y la agrega a la lista de figuras.
     *
     * @param evt El evento del mouse que contiene la información sobre la
     * posición del clic
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (isSeleccionado()) {
            // Primero, deselecciona todas las figuras
            for (MiShape figura : listaFiguras) {
                figura.setSeleccionado(false);
            }

            // Luego, selecciona la figura en la que se hizo clic, si hay alguna
            forma = figuraSeleccionada(evt.getPoint());
            if (forma != null) {
                forma.setSeleccionado(true);
            }
            
            this.repaint();
        }
        if (mover) {
            forma = figuraSeleccionada(evt.getPoint());
            if (forma != null) {
                puntoAnclaje = evt.getPoint(); // Guarda el punto de anclaje
            }
        } else {
            if(tipoforma != null){
                switch(tipoforma){
                    case LINEA:
                        // Crear una nueva línea 
                        Line2D.Float linea = new Line2D.Float(evt.getPoint(), evt.getPoint());

                        // Crear una nueva MiLinea con la línea creada
                        forma = new MiLinea(linea);
                    break;
                    case ELIPSE:
                        punto = evt.getPoint();
                        
                        // Crear una nueva elipse
                        Ellipse2D.Float elipse = new Ellipse2D.Float(evt.getX(), evt.getY(), 1, 1);
                        
                        // Crear una nueva MiElipse con la elipse creada
                        forma = new MiElipse(elipse);
                    break;
                    case RECTANGULO:
                        punto = evt.getPoint();
                        
                        // Crear un rectangulo nuevo
                        Rectangle.Float rectangulo = new Rectangle.Float(evt.getX(), evt.getY(), 1, 1);
                        
                        // Crear un nuevo MiRectangulo con el rectangulo creado
                        forma = new MiRectangulo(rectangulo);
                    break;
                    case FANTASMA:
                        punto = evt.getPoint();

                        // Crear un nuevo fantasma
                        MiFantasma fantasma = new MiFantasma(evt.getX(), evt.getY());

                        // Crear una nueva MiFantasma con el fantasma creado
                        forma = fantasma;
                }
                // Añadir forma al vector de figuras y establecer sus atributos
                listaFiguras.add(forma);
                forma.setColor(getColor());
                forma.setGrosor(new BasicStroke(this.Grosor));
                forma.setRelleno(isRelleno());
                forma.setTransparencia(isTransparencia());
                forma.setAlisado(getAlisado());
            }
        }
    }//GEN-LAST:event_formMousePressed
    /**
     * Este método se ejecuta cuando se arrastra el mouse en el lienzo. Si el
     * modo mover está activado y se ha seleccionado una forma, la mueve. Si no
     * está en modo mover y se está dibujando una forma, actualiza su tamaño o
     * posición según el movimiento del mouse.
     *
     * @param evt El evento del mouse que contiene la información sobre la
     * posición del arrastre
     */
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (mover && forma != null && puntoAnclaje != null) {
            int dx = evt.getX() - puntoAnclaje.x; // Calcula el desplazamiento en x
            int dy = evt.getY() - puntoAnclaje.y; // Calcula el desplazamiento en y
            //Código para el caso de la Linea
            if (forma instanceof MiLinea) {
                Point2D nuevaPos = new Point2D.Double(((MiLinea) forma).getLinea().getX1() + dx, ((MiLinea) forma).getLinea().getY1() + dy);
                ((MiLinea) forma).setLocation(nuevaPos);
            }
            //Código para el caso de la Elipse
            if (forma instanceof MiElipse) {
                Point2D nuevaPos = new Point2D.Double(((MiElipse) forma).getElipse().getCenterX() + dx, ((MiElipse) forma).getElipse().getCenterY() + dy);
                ((MiElipse) forma).setLocation(nuevaPos);
            }
            //Código para el caso del rectángulo
            if (forma instanceof MiRectangulo) {
                Point2D nuevaPos = new Point2D.Double(((MiRectangulo) forma).getRectangulo().getCenterX() + dx, ((MiRectangulo) forma).getRectangulo().getCenterY() + dy);
                ((MiRectangulo) forma).setLocation(nuevaPos);
            }
            // Código para el caso del fantasma
            if (forma instanceof MiFantasma) {
                Point2D nuevaPos = new Point2D.Double(((MiFantasma) forma).getFantasma().getBounds2D().getCenterX() + dx, ((MiFantasma) forma).getFantasma().getBounds2D().getCenterY() + dy);
                ((MiFantasma) forma).setLocation(nuevaPos);
            }
            puntoAnclaje = evt.getPoint(); // Actualiza el punto de anclaje
        }
        else{
            if (tipoforma != null && tipoforma == tipoOpcion.LINEA) {
                // Actualizar la forma de la Linea
                ((MiLinea) forma).getLinea().setLine(((MiLinea) forma).getLinea().getP1(), evt.getPoint());
            }
            if (tipoforma != null && tipoforma == tipoOpcion.ELIPSE){
                // Actualizar la forma de la Elipse
                ((MiElipse) forma).getElipse().setFrameFromDiagonal(punto, evt.getPoint());
            }
            if (tipoforma != null && tipoforma == tipoOpcion.RECTANGULO){
                // Actualizar la forma del Rectángulo
                ((MiRectangulo)forma).getRectangulo().setFrameFromDiagonal(punto, evt.getPoint());
            }
            if (tipoforma != null && tipoforma == tipoOpcion.FANTASMA) {
                // Actualizar la forma del fantasma
                ((MiFantasma) forma).crearFantasma(evt.getX(), evt.getY());
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
