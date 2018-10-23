package power_ups;

import juego.Agregable;
import juego.GameObject;

public abstract class FabricaPowerUp implements Agregable {

	protected Agregable mapa;
	
	public FabricaPowerUp(Agregable mapa) {
		this.mapa = mapa;
	}
	
	@Override
	public void addToObjects(GameObject o) {
		// TODO Auto-generated method stub

	}

	public abstract void crearPowerUp(int x, int y);
}
