package naves;

import disparos.FabricaDisparos;
import juego.Agregable;
import juego.GameObject;
import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	protected int dmg, alcance, velocidad;
	protected FabricaDisparos arma;

	public Nave(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
		this.dmg = dmg;
		this.alcance = alcance;
		this.velocidad = velocidad;
	}

	public void disparar() {
		if (arma != null) {
			arma.crearDisparo(this.rec.x + this.rec.width / 2, this.rec.y - this.rec.height / 2);
		}
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
		this.setVida(this.getVida() - d);
	}

	public abstract void aplicarPowerUp(PowerUp p);

	protected abstract void setearEstadisticas(int lvl);
}
