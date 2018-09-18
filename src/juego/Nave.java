package juego;

import disparos.FabricaDisparos;
import disparos.FabricaSimple;
import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	protected NaveState state;
	protected FabricaDisparos arma;

	public Nave(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Mapa m) {
		super(x, y, vida, durabilidad);
		this.state = new NaveState(vida, durabilidad, dmg, alcance, velocidad);
		this.arma = new FabricaSimple(m);
	}

	@Override
	public void eliminar() {
		this.setVisible(false);
	}

	public int getDmg() {
		return state.getDmg();
	}

	public void setDmg(int dmg) {
		state.setDmg(dmg);
	}

	public int getAlcance() {
		return state.alcance;
	}

	public void setAlcance(int alcance) {
		state.alcance = alcance;
	}

	public int getVelocidad() {
		return state.velocidad;
	}

	public void setVelocidad(int velocidad) {
		state.velocidad = velocidad;
	}

	public void recibirDano(int d) {
		this.setVida(this.state.vida -= d);
	}

	public abstract void disparar();

	public abstract void aplicarPowerUp(PowerUp p);
}
