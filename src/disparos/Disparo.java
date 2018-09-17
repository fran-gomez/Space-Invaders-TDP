package disparos;

import java.awt.Rectangle;

import juego.GameObject;

public abstract class Disparo extends GameObject {

	protected int dmg;
	
	public Disparo(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad);
		this.dmg = dmg;
		// TODO Auto-generated constructor stub
	}

	public Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y);
	}
	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	
}
