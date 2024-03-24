/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package p4_smm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
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

    Shape forma = new Line2D.Float(0,0,0,0);
    private Color color = Color.BLACK;
    private boolean relleno = false;
    public enum tipoOpcion{LINEA, RECTANGULO, ELIPSE};
    tipoOpcion tipoforma = tipoOpcion.LINEA;
    private Point punto;
    private boolean mover = false;
    private List<Shape> vShape = new ArrayList();
    
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
        g2d.setPaint(color);
        for(Shape s:vShape){
            if (isRelleno()){
                g2d.fill(s);
            }
            g2d.draw(s);
        }
    }
    
    private Shape figuraSeleccionada(Point2D p){
        for(Shape s:vShape){
            if(s.contains(p)) return s;
        }
        return null;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
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
