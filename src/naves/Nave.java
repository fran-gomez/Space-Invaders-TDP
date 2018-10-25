package naves;

import disparos.FabricaDisparos;
import juego.Agregable;
import juego.GameObject;
import juego.NaveState;
import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	protected NaveState state;
	protected FabricaDisparos arma;

	public Nave(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
		this.state = new NaveState(vida, durabilidad, dmg, alcance, velocidad);
	}

	public void disparar() {
		if (arma != null) {
			arma.crearDisparo(this.rec.x + this.rec.width / 2, this.rec.y - this.rec.height / 2);
		}
	}

	public int getDmg() {
		return state.getDmg();
	}

	public void setDmg(int dmg) {
		state.setDmg(dmg);
	}

	public int getAlcance() {
		return state.getAlcance();
	}

	public void setAlcance(int alcance) {
		state.setAlcance(alcance);
	}

	public int getVelocidad() {
		return state.getVelocidad();
	}

	public void setVelocidad(int velocidad) {
		state.setVelocidad(velocidad);
	}

	public void recibirDano(int d) {
		this.setVida(this.getVida() - d);
	}

	public abstract void aplicarPowerUp(PowerUp p);

	protected abstract void setearEstadisticas(int lvl);
}
