package obstaculos;

import disparos.Disparo;
import juego.GameObject;
import juego.ObjectState;
import naves.NaveEnemiga;

public abstract class Obstaculo extends GameObject {

	protected int dmg;

	public Obstaculo(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		state = new ObjectState(vida, durabilidad);
	}

	public int getDmg() {
		return dmg;
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	@Override
	public void colision(NaveEnemiga ne) {
		ne.colision(this);
		System.out.println("Colision de obstaculo con nave enemiga.");
	}

	@Override
	public void colision(Disparo d) {
		System.out.println("Colision de obstaculo con disparo.");
	}
}
