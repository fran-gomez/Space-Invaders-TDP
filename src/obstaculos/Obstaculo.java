package obstaculos;
import juego.GameObject;
import utilidades.Punto;

public abstract class Obstaculo extends GameObject {

	public Obstaculo(Punto posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);
	}

}
