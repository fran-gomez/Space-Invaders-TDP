package juego;

import java.io.Serializable;

public class NaveState extends ObjectState implements Serializable {

	protected int dmg, alcance, velocidad;
	
	public NaveState(int vida, int durabilidad, int dmg, int alcance, int velocidad) {
		super(vida, durabilidad);
		this.dmg = dmg;
		this.alcance = alcance;
		this.velocidad = velocidad;
	}
}
