package obstaculos;
import juego.GameObject;

public abstract class Obstaculo extends GameObject {

	public Obstaculo(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
	}

}
