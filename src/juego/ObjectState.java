package juego;

import java.io.Serializable;

public class ObjectState implements Serializable {

	protected int vida, durabilidad;

	public ObjectState(int vida, int durabilidad) {
		this.vida = vida;
		this.durabilidad = durabilidad;
	}
}
