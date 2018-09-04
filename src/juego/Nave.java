package juego;

import javax.swing.Icon;

import power_ups.PowerUp;
import utilidades.Punto;

public abstract class Nave extends GameObject {
	protected int dmg, alcance, velocidad;
	protected Icon visual;
	
	/**
	 * 
	 * @param posicion
	 * @param vida
	 * @param durabilidad
	 * @param alcance
	 * @param dmg
	 * @param velocidad
	 */
	public Nave(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad);
		visual = null;
	}
	
	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void recibirDano(int d) {
		this.vida -= d;
	}
	
	public abstract void disparar();
	public abstract void aplicarPowerUp(PowerUp p);
}
