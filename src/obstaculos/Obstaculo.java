package obstaculos;

import juego.Agregable;
import juego.GameObject;
import juego.ObjectState;

public abstract class Obstaculo extends GameObject {

	protected int dmg;

	public Obstaculo(int x, int y, int vida, int durabilidad, int d, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
		this.dmg = d;
		state = new ObjectState(vida, durabilidad);
	}

	public int getDmg() {
		return dmg;
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}
}
