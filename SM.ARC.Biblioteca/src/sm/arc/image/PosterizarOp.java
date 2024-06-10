/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sm.arc.image;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author Alejandro Rosales Cantero
 */
public class PosterizarOp extends BufferedImageOpAdapter {
    private int niveles;

    /**
     * Constructor que inicializa el número de niveles para el efecto de posterización.
     * 
     * @param niveles El número de niveles de color para la posterización.
     */
    public PosterizarOp(int niveles) {
        this.niveles = niveles;
    }

    /**
     * Aplica el filtro de posterización a la imagen de origen.
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
        int sample;

        // Calcula el factor de cuantización
        float k = 256.f / niveles;

        // Itera sobre cada píxel de la imagen
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                // Itera sobre cada componente de color (banda) del píxel
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    // Obtiene el valor del componente de color
                    sample = srcRaster.getSample(x, y, band);
                    // Aplica la cuantización para la posterización
                    sample = (int) (k * (int) (sample / k));
                    // Establece el nuevo valor del componente de color en la imagen de destino
                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        return dest;
    }
}
