package utilidades;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class FormateadorDeImagen {

	/**
	 * Cambia el tamaño del imageIcon
	 * 
	 * @param visual original
	 * @param w      ancho destino
	 * @param h      alto destino
	 * @return ImageIcon de resultado
	 */
	public static ImageIcon formatearImagen(ImageIcon visual, int w, int h) {
		// Cambio de tamaño acorde al objeto
		Image img = visual.getImage();
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		Image dimg = bimage.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(dimg);
	}
}
