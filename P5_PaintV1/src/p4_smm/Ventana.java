/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p4_smm;

import java.awt.Color;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        MenuDibujos = new javax.swing.JToolBar();
        BotonLinea = new javax.swing.JToggleButton();
        BotonRectangulo = new javax.swing.JToggleButton();
        BotonElipse = new javax.swing.JToggleButton();
        BotonColores = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        BotonRellenar = new javax.swing.JCheckBox();
        BotonColorNegro = new javax.swing.JToggleButton();
        BotonColorBlanco = new javax.swing.JToggleButton();
        BotonColorRojo = new javax.swing.JToggleButton();
        BotonColorAmarillo = new javax.swing.JToggleButton();
        BotonColorAzul = new javax.swing.JToggleButton();
        BotonColorVerde = new javax.swing.JToggleButton();
        BotonMover = new javax.swing.JCheckBox();
        Lienzo = new p4_smm.Lienzo();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setSize(new java.awt.Dimension(900, 700));

        MenuDibujos.setBackground(new java.awt.Color(204, 204, 204));
        MenuDibujos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MenuDibujos.setRollover(true);

        buttonGroup1.add(BotonLinea);
        BotonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        BotonLinea.setFocusable(false);
        BotonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLinea.setPreferredSize(new java.awt.Dimension(40, 40));
        BotonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLineaActionPerformed(evt);
            }
        });
        MenuDibujos.add(BotonLinea);

        buttonGroup1.add(BotonRectangulo);
        BotonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        BotonRectangulo.setFocusable(false);
        BotonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRectangulo.setPreferredSize(new java.awt.Dimension(40, 40));
        BotonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRectanguloActionPerformed(evt);
            }
        });
        MenuDibujos.add(BotonRectangulo);

        buttonGroup1.add(BotonElipse);
        BotonElipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        BotonElipse.setFocusable(false);
        BotonElipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonElipse.setPreferredSize(new java.awt.Dimension(40, 40));
        BotonElipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonElipseActionPerformed(evt);
            }
        });
        MenuDibujos.add(BotonElipse);

        getContentPane().add(MenuDibujos, java.awt.BorderLayout.PAGE_START);

        BotonColores.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("Barra de Estado");

        BotonRellenar.setText("Relleno");
        BotonRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRellenarActionPerformed(evt);
            }
        });

        BotonColorNegro.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(BotonColorNegro);
        BotonColorNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorNegroActionPerformed(evt);
            }
        });

        buttonGroup2.add(BotonColorBlanco);
        BotonColorBlanco.setForeground(new java.awt.Color(255, 255, 255));
        BotonColorBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorBlancoActionPerformed(evt);
            }
        });

        BotonColorRojo.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup2.add(BotonColorRojo);
        BotonColorRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorRojoActionPerformed(evt);
            }
        });

        BotonColorAmarillo.setBackground(new java.awt.Color(255, 255, 51));
        buttonGroup2.add(BotonColorAmarillo);
        BotonColorAmarillo.setForeground(new java.awt.Color(255, 255, 255));
        BotonColorAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorAmarilloActionPerformed(evt);
            }
        });

        BotonColorAzul.setBackground(new java.awt.Color(0, 0, 255));
        buttonGroup2.add(BotonColorAzul);
        BotonColorAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorAzulActionPerformed(evt);
            }
        });

        BotonColorVerde.setBackground(new java.awt.Color(51, 255, 0));
        buttonGroup2.add(BotonColorVerde);
        BotonColorVerde.setForeground(new java.awt.Color(255, 255, 255));
        BotonColorVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonColorVerdeActionPerformed(evt);
            }
        });

        BotonMover.setText("Mover");
        BotonMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotonColoresLayout = new javax.swing.GroupLayout(BotonColores);
        BotonColores.setLayout(BotonColoresLayout);
        BotonColoresLayout.setHorizontalGroup(
            BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BotonColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonColoresLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(BotonColoresLayout.createSequentialGroup()
                        .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BotonColoresLayout.createSequentialGroup()
                                .addComponent(BotonColorNegro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonColorRojo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonColorAzul))
                            .addGroup(BotonColoresLayout.createSequentialGroup()
                                .addComponent(BotonColorBlanco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonColorAmarillo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonColorVerde)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 720, Short.MAX_VALUE)
                        .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonRellenar)
                            .addComponent(BotonMover))
                        .addContainerGap())))
        );
        BotonColoresLayout.setVerticalGroup(
            BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonColoresLayout.createSequentialGroup()
                .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonColoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonColorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BotonColoresLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(BotonRellenar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BotonColorBlanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonColorAmarillo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonColorVerde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotonMover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(BotonColores, java.awt.BorderLayout.PAGE_END);

        Lienzo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout LienzoLayout = new javax.swing.GroupLayout(Lienzo);
        Lienzo.setLayout(LienzoLayout);
        LienzoLayout.setHorizontalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        LienzoLayout.setVerticalGroup(
            LienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        getContentPane().add(Lienzo, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonColorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorNegroActionPerformed
        this.Lienzo.setColor(Color.black);
    }//GEN-LAST:event_BotonColorNegroActionPerformed

    private void BotonColorBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorBlancoActionPerformed
        this.Lienzo.setColor(Color.white);
    }//GEN-LAST:event_BotonColorBlancoActionPerformed

    private void BotonColorRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorRojoActionPerformed
        this.Lienzo.setColor(Color.red);
    }//GEN-LAST:event_BotonColorRojoActionPerformed

    private void BotonColorAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorAmarilloActionPerformed
        this.Lienzo.setColor(Color.yellow);
    }//GEN-LAST:event_BotonColorAmarilloActionPerformed

    private void BotonColorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorAzulActionPerformed
        this.Lienzo.setColor(Color.blue);
    }//GEN-LAST:event_BotonColorAzulActionPerformed

    private void BotonColorVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorVerdeActionPerformed
        this.Lienzo.setColor(Color.green);
    }//GEN-LAST:event_BotonColorVerdeActionPerformed

    private void BotonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLineaActionPerformed
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.LINEA;
    }//GEN-LAST:event_BotonLineaActionPerformed

    private void BotonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRectanguloActionPerformed
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.RECTANGULO;
    }//GEN-LAST:event_BotonRectanguloActionPerformed

    private void BotonElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonElipseActionPerformed
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.ELIPSE;
    }//GEN-LAST:event_BotonElipseActionPerformed

    private void BotonRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRellenarActionPerformed
        this.Lienzo.setRelleno(BotonRellenar.isSelected());
        this.repaint();
    }//GEN-LAST:event_BotonRellenarActionPerformed

    private void BotonMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMoverActionPerformed
        this.Lienzo.setMover(BotonMover.isSelected());
    }//GEN-LAST:event_BotonMoverActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonColorAmarillo;
    private javax.swing.JToggleButton BotonColorAzul;
    private javax.swing.JToggleButton BotonColorBlanco;
    private javax.swing.JToggleButton BotonColorNegro;
    private javax.swing.JToggleButton BotonColorRojo;
    private javax.swing.JToggleButton BotonColorVerde;
    private javax.swing.JPanel BotonColores;
    private javax.swing.JToggleButton BotonElipse;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JCheckBox BotonMover;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.JCheckBox BotonRellenar;
    private p4_smm.Lienzo Lienzo;
    private javax.swing.JToolBar MenuDibujos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
