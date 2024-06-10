/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class CambiarTonoColorOP extends BufferedImageOpAdapter {
    
    private Color C1;
    private Color C2;
    private float umbral;

    /**
     * Constructor que inicializa los colores y el umbral para el cambio de tono.
     * 
     * @param C1 El primer color de referencia.
     * @param C2 El segundo color de referencia.
     * @param umbral El umbral de distancia para realizar el cambio de tono.
     */
    public CambiarTonoColorOP(Color C1, Color C2, float umbral) {
        this.C1 = C1;
        this.C2 = C2;
        this.umbral = umbral;
    }
    
    /**
     * Aplica el filtro para cambiar el tono del color en la imagen de origen.
     * 
     * @param src La imagen de origen.
     * @param dest La imagen de destino. Si es null, se crea una imagen compatible.
     * @return La imagen de destino con el filtro aplicado.
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("La imagen de origen es null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        int[] pixelComp = new int[srcRaster.getNumBands()];
        int[] pixelCompDest = new int[srcRaster.getNumBands()];
        
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                // Obtiene los componentes del píxel en la posición (x, y)
                srcRaster.getPixel(x, y, pixelComp);
         
                // Convierte C1 y C2 de RGB a HSB
                float[] hsbC1 = Color.RGBtoHSB(C1.getRed(), C1.getGreen(), C1.getBlue(), null);
                float H1 = hsbC1[0] * 360;

                float[] hsbC2 = Color.RGBtoHSB(C2.getRed(), C2.getGreen(), C2.getBlue(), null);
                float H2 = hsbC2[0] * 360;

                // Convierte el color del píxel actual de RGB a HSB
                float[] hsbCol = Color.RGBtoHSB(pixelComp[0], pixelComp[1], pixelComp[2], null);
                float H = hsbCol[0] * 360;
                
                // Calcula la distancia entre el tono del píxel y el tono H1
                float distancia = Math.abs(H - H1);
                
                // Ajusta la distancia para considerar la circularidad del modelo de color HSB
                if (distancia > 180) {
                    distancia = 360 - distancia;
                }
                
                // Si la distancia es menor o igual al umbral, cambia el tono del píxel
                if (distancia <= umbral) {
                    hsbCol[0] = H2 / 360.0f;
                }
                
                // Convierte el color HSB modificado de vuelta a RGB
                int rgb = Color.HSBtoRGB(hsbCol[0], hsbCol[1], hsbCol[2]);
                pixelCompDest[0] = (rgb >> 16) & 0xFF; // Componente rojo
                pixelCompDest[1] = (rgb >> 8) & 0xFF;  // Componente verde
                pixelCompDest[2] = rgb & 0xFF;         // Componente azul

                // Establece el nuevo color del píxel en la imagen de destino
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }
}

    
