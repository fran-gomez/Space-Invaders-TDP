package juego;

import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	// protected NaveState state;

	public Nave(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x, y, vida, durabilidad);
		state = new NaveState(vida, durabilidad, dmg, alcance, velocidad);
	}

	@Override
	public void eliminar() {
		this.setVisible(false);
		// TODO borrar de los objetos
	}

	public int getDmg() {
		return ((NaveState) this.state).getDmg();
	}

	public void setDmg(int dmg) {
		((NaveState) this.state).setDmg(dmg);
	}

	public int getAlcance() {
		return ((NaveState) this.state).alcance;
	}

	public void setAlcance(int alcance) {
		((NaveState) this.state).alcance = alcance;
	}

	public int getVelocidad() {
		return ((NaveState) this.state).velocidad;
	}

	public void setVelocidad(int velocidad) {
		((NaveState) this.state).velocidad = velocidad;
	}

	public void recibirDano(int d) {
		this.setVida(this.state.vida -= d);
	}

	public abstract void disparar();

	public abstract void aplicarPowerUp(PowerUp p);
}
