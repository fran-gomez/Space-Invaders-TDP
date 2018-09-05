package juego;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import utilidades.Recuadro;

public abstract class GameObject extends JLabel {
	protected int vida, durabilidad;
	protected Recuadro rec;

	public GameObject(int x, int y, int vida, int durabilidad) {
		this.rec = createRectangle(x, y);
		this.vida = vida;
		this.durabilidad = durabilidad;

		rec.setX(rec.x() - rec.getAncho() / 2);
		rec.setY(rec.y() - rec.getAlto() / 2);
		this.setLocation(rec.x(), rec.y());

		this.setText(getName());
		this.setPreferredSize(new Dimension(rec.getAncho(), rec.getAlto()));
		this.setSize(new Dimension(rec.getAncho(), rec.getAlto()));
		this.setForeground(Color.WHITE);
		this.setOpaque(true);
		this.setBackground(Color.gray);
	}

	public abstract void borrar();

	public abstract void colision(GameObject o1);

	public abstract void mover();

	protected abstract Recuadro createRectangle(int x, int y);

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

	public Recuadro getRectangle() {
		return rec;
	}

	public void setRectangle(Recuadro rec) {
		this.rec = rec;
	}

}
