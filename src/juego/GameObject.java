package juego;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class GameObject extends JLabel {
	protected int vida, durabilidad;
	protected Rectangle rec;

	protected ImageIcon visual;

	public GameObject(int x, int y, int vida, int durabilidad) {
		this.rec = createRectangle(x, y);
		this.vida = vida;
		this.durabilidad = durabilidad;
		this.visual = null;

		rec.setLocation((int) (rec.getLocation().getX() - rec.getWidth() / 2),
				(int) (rec.getLocation().getY() - rec.getHeight() / 2));
		this.setBounds(rec);
		this.setOpaque(true);
		
		visual = getGrafico();
		if (visual != null) {
			Image img = visual.getImage();
			BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		    // Draw the image on to the buffered image
		    Graphics2D bGr = bimage.createGraphics();
		    bGr.drawImage(img, 0, 0, null);
		    bGr.dispose();

		    Image dimg = bimage.getScaledInstance((int)rec.getWidth(), (int)rec.getHeight(),Image.SCALE_SMOOTH);
		    visual = new ImageIcon(dimg);
			this.setIcon(visual);
		}
	}

	public abstract void borrar();

	public abstract void colision(GameObject o1);

	public abstract void mover();

	public abstract ImageIcon getGrafico();

	protected abstract Rectangle createRectangle(int x, int y);

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDurabilidad() {
		return durabilidad;
	}

	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}

	public Rectangle getRectangle() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	public ImageIcon getVisual() {
		return visual;
	}

	public void setVisual(ImageIcon visual) {
		this.visual = visual;
	}

}
