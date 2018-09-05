package juego;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import utilidades.Recuadro;

public abstract class GameObject extends JLabel {
	protected int vida, durabilidad;
	protected Recuadro rec;

	public GameObject(Recuadro rec, int vida, int durabilidad) {
		this.rec = rec;
		this.vida = vida;
		this.durabilidad = durabilidad;
		
		this.setLocation(rec.x(), rec.y());
		this.setText(getName());
		this.setPreferredSize(new Dimension(rec.getAncho(), rec.getAlto()));
		this.setSize(new Dimension(rec.getAncho(), rec.getAlto()));
		this.setForeground(Color.WHITE);
	}

	public abstract void borrar();

	public abstract void colision(GameObject o1);

	public abstract void mover();

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
