package juego;

import javax.swing.Icon;

import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	protected NaveState state;
	
	public Nave(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x, y, vida, durabilidad);
		state = new NaveState(vida, durabilidad, dmg, alcance, velocidad);
	}
	
	public int getDmg() {
		return state.dmg;
	}

	public void setDmg(int dmg) {
		this.state.dmg = dmg;
	}

	public int getAlcance() {
		return state.alcance;
	}

	public void setAlcance(int alcance) {
		this.state.alcance = alcance;
	}

	public int getVelocidad() {
		return state.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.state.velocidad = velocidad;
	}
	
	public void recibirDano(int d) {
		this.state.vida -= d;
	}
	
	public abstract void disparar();
	public abstract void aplicarPowerUp(PowerUp p);
}
