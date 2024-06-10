/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class RojoOP extends BufferedImageOpAdapter {
    
    private int umbral;

    /**
     * Constructor que inicializa el umbral para el filtro de detección de rojo.
     * 
     * @param umbral El umbral para determinar si un píxel es predominantemente rojo.
     */
    public RojoOP(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Aplica el filtro para resaltar los píxeles predominantemente rojos en la imagen de origen.
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

        // Itera sobre cada píxel de la imagen
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                // Obtiene los componentes de color del píxel en la posición (x, y)
                srcRaster.getPixel(x, y, pixelComp);
                
                int red = pixelComp[0];
                int green = pixelComp[1];
                int blue = pixelComp[2];

                // Comprueba si el píxel es predominantemente rojo comparando su componente rojo con la suma de los componentes verde y azul
                if (red - (green + blue) > umbral) {
                    // Si el píxel es predominantemente rojo, se mantiene el color original
                    pixelCompDest[0] = red;
                    pixelCompDest[1] = green;
                    pixelCompDest[2] = blue;
                } else {
                    // Si el píxel no es predominantemente rojo, se convierte a nivel de gris
                    int gray = (red + green + blue) / 3;
                    pixelCompDest[0] = gray;
                    pixelCompDest[1] = gray;
                    pixelCompDest[2] = gray;
                }
                
                // Establece el nuevo color del píxel en la imagen de destino
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        return dest;
    }
}