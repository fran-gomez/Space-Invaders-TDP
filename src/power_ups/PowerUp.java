package power_ups;

import Inteligencias.Inteligencia;
import Inteligencias.InteligenciaPowerUpDefecto;
import juego.GameObject;
import juego.ObjectState;

public abstract class PowerUp extends GameObject {

	private InteligenciaPowerUpDefecto inteligencia;
	
	public PowerUp(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		state = new ObjectState(vida, durabilidad);
		inteligencia = new InteligenciaPowerUpDefecto();
	}

	
	public void mover() {
		inteligencia.actualizarPosicion(this);
	}
	
	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}
	
	public abstract void efecto();
}
