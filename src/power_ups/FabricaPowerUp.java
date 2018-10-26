package power_ups;

import juego.Agregable;

public abstract class FabricaPowerUp {

	protected Agregable mapa;

	public FabricaPowerUp(Agregable mapa) {
		this.mapa = mapa;
	}

	public abstract void crearPowerUp(int x, int y);
}
