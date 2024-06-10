/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package sm.arc.iu;

import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class VentanaInternaVideo extends javax.swing.JInternalFrame {

    // Reproductor de video incrustado
    private EmbeddedMediaPlayer vlcplayer = null;
    // Archivo de video a reproducir
    private File fMedia;
    
    /**
     * Constructor privado que inicializa una nueva instancia de VentanaInternaVideo.
     * 
     * @param f El archivo de video a reproducir.
     */
    private VentanaInternaVideo(File f) {
        initComponents();
        
        // Asigna el archivo de video
        fMedia = f;
        
        // Crea un componente visual para el reproductor de video incrustado
        EmbeddedMediaPlayerComponent aVisual = new EmbeddedMediaPlayerComponent();
        getContentPane().add(aVisual, java.awt.BorderLayout.CENTER);
        
        // Obtiene el reproductor de video del componente visual
        vlcplayer = aVisual.getMediaPlayer();
    }
    
    /**
     * Método estático para obtener una instancia única de VentanaInternaVideo.
     * 
     * @param f El archivo de video a reproducir.
     * @return Una instancia de VentanaInternaVideo si el reproductor está disponible, o null si no lo está.
     */
    public static VentanaInternaVideo getInstance(File f) {
        VentanaInternaVideo v = new VentanaInternaVideo(f);
        return (v.vlcplayer != null ? v : null);
    }

    /**
     * Método para reproducir el video.
     */
    public void play() {
        if (vlcplayer != null) {
            if (vlcplayer.isPlayable()) {
                // Si se estaba reproduciendo, continúa la reproducción
                vlcplayer.play();
            } else {
                // Si no se estaba reproduciendo, inicia la reproducción del video
                vlcplayer.playMedia(fMedia.getAbsolutePath());
            }
        }
    }

    /**
     * Método para detener la reproducción del video.
     */
    public void stop() {
        if (vlcplayer != null) {
            if (vlcplayer.isPlaying()) {
                // Si está reproduciendo, pausa la reproducción
                vlcplayer.pause();
            } else {
                // Si no está reproduciendo, detiene la reproducción
                vlcplayer.stop();
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        setBounds(0, 0, 406, 310);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método llamado al cerrar la ventana interna, se encarga de detener la reproducción del video.
     * 
     * @param evt El evento de cierre de la ventana interna.
     */
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if(vlcplayer!=null){
            vlcplayer.stop();
            vlcplayer = null;
        }
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
