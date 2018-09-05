package obstaculos;
import juego.GameObject;
import utilidades.Recuadro;

public abstract class Obstaculo extends GameObject {

	public Obstaculo(Recuadro posicion, int vida, int durabilidad) {
		super(posicion, vida, durabilidad);
	}

}
