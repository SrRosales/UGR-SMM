/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package p4_smm;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class Lienzo extends javax.swing.JPanel {

    // Variable que representa la forma actual que se está dibujando en el lienzo
    Shape forma = new Line2D.Float(0,0,0,0);
    
    // Variable que almacena el color actual para dibujar en el lienzo
    private Color color = Color.BLACK;
    
    // Variable que indica si se debe rellenar la forma dibujada en el lienzo
    private boolean relleno = false;
    
    // Enumeración que define los tipos de formas disponibles para dibujar en el lienzo
    public enum tipoOpcion{LINEA, RECTANGULO, ELIPSE};
    
    // Tipo de forma seleccionada por defecto
    tipoOpcion tipoforma = tipoOpcion.LINEA;
    
    // Variable que almacena el punto inicial de la forma dibujada
    private Point punto;
    
    // Variable que indica si el modo mover está activado o desactivado
    private boolean mover = false;
    
    // Lista que almacena todas las formas dibujadas en el lienzo
    private List<Shape> vShape = new ArrayList();
    
    // Variable que define el grosor del trazo para las formas dibujadas
    private Stroke trazo = new BasicStroke();
    
    // Variable que indica si el alisado de las formas está activado o desactivado
    private Boolean alisado = false;
    
    // Variable que indica si la transparencia de las formas está activada o desactivada
    private boolean transparencia = false;
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g; 
        
        // Asignar el color de las figuras
        g2d.setPaint(color);
        
        // Asignar el grosor del trazo
        g2d.setStroke(trazo);
        
        // Verificar si el alisado está activado
        if (alisado) {
            // Activar el alisado
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            // Desactivar el alisado
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        
        // Verificar si la transparencia está activada
        if (transparencia) {
            // Aplicar una transparencia (alfa) de 0.5
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        } else {
            // Restaurar la transparencia predeterminada (sin transparencia)
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }
        
        // Dibujar las figuras, si esta seleccionado el botonRelleno se rellenan
        // en caso contrario se dibuha la figura sin relleno
        for(Shape s:vShape){
            if (isRelleno()){
                g2d.fill(s);
            }
            g2d.draw(s);
        }
    }
    
    // Método que devuelve la forma seleccionada en el punto dado
    private Shape figuraSeleccionada(Point2D p) {
        for (Shape s : vShape) {
            if (s.contains(p)) {
                return s;
            }
        }
        return null;
    }

    // Método para establecer el color actual de dibujo
    public void setColor(Color color) {
        this.color = color;
    }

    // Método para obtener el color actual de dibujo
    public Color getColor() {
        return color;
    }

    // Método para establecer si se debe rellenar la forma dibujada
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    // Método para verificar si se debe rellenar la forma dibujada
    public boolean isRelleno() {
        return relleno;
    }

    // Método para verificar si el modo mover está activado
    public boolean isMover() {
        return mover;
    }

    // Método para activar o desactivar el modo mover
    public void setMover(boolean mover) {
        this.mover = mover;
    }

    // Método para obtener el grosor del trazo actual
    public Stroke getGrosor() {
        return trazo;
    }

    // Método para establecer el grosor del trazo
    public void setGrosor(int grosor) {
        this.trazo = new BasicStroke(grosor);
    }

    // Método para establecer si el alisado de formas está activado
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
        this.repaint();
    }

    // Método para establecer si la transparencia de formas está activada
    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
        repaint();
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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(mover){
            forma = figuraSeleccionada(evt.getPoint());
        }else{   
        switch (tipoforma) {
            case LINEA:
                forma = new MiLinea(evt.getPoint(), evt.getPoint());
                break;
            case RECTANGULO:
                punto = evt.getPoint();
                forma = new Rectangle();
                break;
            case ELIPSE:
                punto = evt.getPoint();
                forma = new MiElipse();
                break;
            }
        vShape.add(forma);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (mover) {
            //Código para el caso del rectángulo
            if (forma!=null && forma instanceof Rectangle){
                    ((Rectangle)forma).setLocation(evt.getPoint()); 
            }
            //Código para el caso de la Linea
            if (forma!=null && forma instanceof Line2D){
                ((MiLinea)forma).setLocation(evt.getPoint()); 
            }
            //Código para el caso de la Elipse
            if (forma!=null && forma instanceof Ellipse2D){
                    ((MiElipse)forma).setLocation(evt.getPoint()); 
            }
        }else{
            if(tipoforma == tipoOpcion.LINEA){
                ((MiLinea)forma).setLine(((Line2D)forma).getP1(), evt.getPoint());
            }
            if(tipoforma == tipoOpcion.RECTANGULO){
                ((Rectangle)forma).setFrameFromDiagonal(punto, evt.getPoint());
            }
            if(tipoforma == tipoOpcion.ELIPSE){
                ((MiElipse)forma).setFrameFromDiagonal(punto, evt.getPoint());
            }
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
