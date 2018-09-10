package disparos;

import juego.GameObject;

public abstract class Disparo extends GameObject {

	public Disparo(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

}
