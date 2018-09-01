package juego;

import javax.swing.JLabel;
import utilidades.Punto;

public abstract class GameObject extends JLabel {
	private int vida, durabilidad;
	private Punto pos;

	public GameObject(Punto posicion, int vida, int durabilidad) {
		this.pos = posicion;
		this.vida = vida;
		this.durabilidad = durabilidad;
	}

	public abstract void actualizarPosicion();

	public abstract void borrar();

	public abstract void colision();

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

	public Punto getPos() {
		return pos;
	}

	public void setPos(Punto pos) {
		this.pos = pos;
	}
}
