package juego;

import power_ups.PowerUp;

public abstract class Nave extends GameObject {
	private int dmg, alcance, velocidad;
	
	protected abstract void disparar();
	protected abstract void aplicarPowerUp(PowerUp p);
}
