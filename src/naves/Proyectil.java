package naves;

import juego.GameObject;
import utilidades.Recuadro;

public abstract class Proyectil extends GameObject {
	private int dmg, alcance;

	public Proyectil(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
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
	public void borrar() {
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}

}
