package obstaculos;
import disparos.Disparo;
import juego.GameObject;
import naves.NaveEnemiga;

public abstract class Obstaculo extends GameObject {

	protected int dmg;
	
	public Obstaculo(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
	}

	public int getDmg() {
		return dmg;
	}
	
	public abstract void colisionar(Disparo d);
	public abstract void colisionar(NaveEnemiga ne);
}
