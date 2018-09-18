package power_ups;

import juego.GameObject;
import juego.ObjectState;
import naves.NaveAliada;

public abstract class PowerUp extends GameObject {

	public PowerUp(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		state = new ObjectState(vida, durabilidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	public void colision(NaveAliada na) {
		na.colision(this);
	}
	
	public abstract void efecto();
}
