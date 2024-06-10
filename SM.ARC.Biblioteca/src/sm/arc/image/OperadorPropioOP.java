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
public class OperadorPropioOP  extends BufferedImageOpAdapter{
 
    private float intensidad; // Parámetro para controlar la intensidad del aumento de saturación

    public OperadorPropioOP(float intensidad) {
        if (intensidad < 0 || intensidad > 1) {
            throw new IllegalArgumentException("La intensidad debe estar entre 0 y 1");
        }
        this.intensidad = intensidad;
    }

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

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);

                // Convertir RGB a HSB
                float[] hsb = java.awt.Color.RGBtoHSB(pixelComp[0], pixelComp[1], pixelComp[2], null);

                // Aumentar la saturación
                hsb[1] = Math.min(1.0f, hsb[1] * (1 + intensidad));

                // Convertir HSB de vuelta a RGB
                int rgb = java.awt.Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);

                // Descomponer el color RGB en componentes
                pixelComp[0] = (rgb >> 16) & 0xFF;
                pixelComp[1] = (rgb >> 8) & 0xFF;
                pixelComp[2] = rgb & 0xFF;

                // Establecer el nuevo color del píxel en la imagen de destino
                destRaster.setPixel(x, y, pixelComp);
            }
        }
        return dest;
    }
}
