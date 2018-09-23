package juego;

import java.io.Serializable;

public class ObjectState implements Serializable {

	protected int vida, durabilidad;

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

	public ObjectState(int vida, int durabilidad) {
		this.vida = vida;
		this.durabilidad = durabilidad;
	}
}
