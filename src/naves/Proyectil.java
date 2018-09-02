package naves;

import juego.GameObject;
import utilidades.Punto;

public class Proyectil extends GameObject{
	private int dmg, alcance;

	public Proyectil(Punto posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);
	}
	
	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	@Override
	public void actualizarPosicion() {
	}

	@Override
	public void borrar() {
	}

	@Override
	public void colision() {
	}
	
	
}
