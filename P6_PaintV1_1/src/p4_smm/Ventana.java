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
        BarraEstado = new javax.swing.JLabel();
        BotonColorNegro = new javax.swing.JToggleButton();
        BotonColorBlanco = new javax.swing.JToggleButton();
        BotonColorRojo = new javax.swing.JToggleButton();
        BotonColorAmarillo = new javax.swing.JToggleButton();
        BotonColorAzul = new javax.swing.JToggleButton();
        BotonColorVerde = new javax.swing.JToggleButton();
        SeccionBotones = new javax.swing.JPanel();
        BotonTransparencia = new javax.swing.JCheckBox();
        BotonTrazo = new javax.swing.JSpinner();
        BotonAlisar = new javax.swing.JCheckBox();
        BotonMover = new javax.swing.JCheckBox();
        BotonRellenar = new javax.swing.JCheckBox();
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

        BarraEstado.setText("Barra de Estado");

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

        SeccionBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BotonTransparencia.setText("Transparencia");
        BotonTransparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTransparenciaActionPerformed(evt);
            }
        });

        BotonTrazo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BotonTrazoStateChanged(evt);
            }
        });

        BotonAlisar.setText("Alisar");
        BotonAlisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAlisarActionPerformed(evt);
            }
        });

        BotonMover.setText("Mover");
        BotonMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMoverActionPerformed(evt);
            }
        });

        BotonRellenar.setText("Relleno");
        BotonRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRellenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeccionBotonesLayout = new javax.swing.GroupLayout(SeccionBotones);
        SeccionBotones.setLayout(SeccionBotonesLayout);
        SeccionBotonesLayout.setHorizontalGroup(
            SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeccionBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SeccionBotonesLayout.createSequentialGroup()
                        .addComponent(BotonTrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonAlisar))
                    .addComponent(BotonTransparencia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonRellenar)
                    .addComponent(BotonMover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SeccionBotonesLayout.setVerticalGroup(
            SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeccionBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonRellenar)
                    .addComponent(BotonTransparencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SeccionBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonMover)
                    .addComponent(BotonAlisar)
                    .addComponent(BotonTrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout BotonColoresLayout = new javax.swing.GroupLayout(BotonColores);
        BotonColores.setLayout(BotonColoresLayout);
        BotonColoresLayout.setHorizontalGroup(
            BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(BotonColoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonColoresLayout.createSequentialGroup()
                        .addComponent(BarraEstado)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                        .addComponent(SeccionBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        BotonColoresLayout.setVerticalGroup(
            BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonColoresLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonColoresLayout.createSequentialGroup()
                        .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BotonColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonColorBlanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorAmarillo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonColorVerde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(SeccionBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BarraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGap(0, 422, Short.MAX_VALUE)
        );

        getContentPane().add(Lienzo, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonColorNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorNegroActionPerformed
        // Establezco el color del lienzo como negro
        this.Lienzo.setColor(Color.black);
    }//GEN-LAST:event_BotonColorNegroActionPerformed

    private void BotonColorBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorBlancoActionPerformed
        // Establezco el color del lienzo como blanco
        this.Lienzo.setColor(Color.white);
    }//GEN-LAST:event_BotonColorBlancoActionPerformed

    private void BotonColorRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorRojoActionPerformed
        // Establezco el color del lienzo como rojo
        this.Lienzo.setColor(Color.red);
    }//GEN-LAST:event_BotonColorRojoActionPerformed

    private void BotonColorAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorAmarilloActionPerformed
        // Establezco el color del lienzo como amarillo
        this.Lienzo.setColor(Color.yellow);
    }//GEN-LAST:event_BotonColorAmarilloActionPerformed

    private void BotonColorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorAzulActionPerformed
        // Establezco el color del lienzo como azul
        this.Lienzo.setColor(Color.blue);
    }//GEN-LAST:event_BotonColorAzulActionPerformed

    private void BotonColorVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonColorVerdeActionPerformed
        // Establezco el color del lienzo como verde
        this.Lienzo.setColor(Color.green);
    }//GEN-LAST:event_BotonColorVerdeActionPerformed

    private void BotonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLineaActionPerformed
        // Establezco el tipo de forma a dibujar como Línea
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.LINEA;
        
        // Actualizo la barra de estado para que indique que se esta dibujando una Linea
        BarraEstado.setText("Dibujando Línea...");
    }//GEN-LAST:event_BotonLineaActionPerformed

    private void BotonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRectanguloActionPerformed
        // Establezco el tipo de forma a dibujar como Rectángulo
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.RECTANGULO;
        
        // Actualizo la barra de estado para que indique que se esta dibujando un Rectángulo
        BarraEstado.setText("Dibujando Rectángulo...");
    }//GEN-LAST:event_BotonRectanguloActionPerformed

    private void BotonElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonElipseActionPerformed
        // Establezco el tipo de forma a dibujar como Elipse
        this.Lienzo.tipoforma = this.Lienzo.tipoforma.ELIPSE;
        
        // Actualizo la barra de estado para que indique que se esta dibujando una Elipse
        BarraEstado.setText("Dibujando Elipse...");
    }//GEN-LAST:event_BotonElipseActionPerformed

    private void BotonRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRellenarActionPerformed
        // Comprobar si el boton relleno esta seleccionado o no
        this.Lienzo.setRelleno(BotonRellenar.isSelected());
        this.repaint();
    }//GEN-LAST:event_BotonRellenarActionPerformed

    private void BotonMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMoverActionPerformed
        // Comprobar si el boton mover esta seleccionado o no
        this.Lienzo.setMover(BotonMover.isSelected());  
        this.repaint();
    }//GEN-LAST:event_BotonMoverActionPerformed

    private void BotonTrazoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BotonTrazoStateChanged
        // Obtener el valor del JSpinner
        int grosor = (int) BotonTrazo.getValue(); 
        
        // Actualizar el grosor del trazo en el lienzo
        Lienzo.setGrosor(grosor); 
        
        // Volver a pintar el lienzo para reflejar el cambio
        Lienzo.repaint(); 
    }//GEN-LAST:event_BotonTrazoStateChanged

    private void BotonAlisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAlisarActionPerformed
        // Verificar si el checkbox está seleccionado
        boolean alisadoActivado = BotonAlisar.isSelected(); 
        
        // Activar o desactivar el alisado en el lienzo
        Lienzo.setAlisado(alisadoActivado); 
        
        // Volver a pintar el lienzo para reflejar el cambio
        Lienzo.repaint(); 
       
    }//GEN-LAST:event_BotonAlisarActionPerformed

    private void BotonTransparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTransparenciaActionPerformed
        // Verificar si el botón de casilla de verificación está seleccionado
        boolean transparenciaActivada = BotonTransparencia.isSelected();

        // Llamar al método setTransparencia del lienzo y pasar el estado actual de la transparencia
        Lienzo.setTransparencia(transparenciaActivada);
    }//GEN-LAST:event_BotonTransparenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BarraEstado;
    private javax.swing.JCheckBox BotonAlisar;
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
    private javax.swing.JCheckBox BotonTransparencia;
    private javax.swing.JSpinner BotonTrazo;
    private p4_smm.Lienzo Lienzo;
    private javax.swing.JToolBar MenuDibujos;
    private javax.swing.JPanel SeccionBotones;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
