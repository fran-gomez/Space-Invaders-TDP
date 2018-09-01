package naves;
import juego.Nave;
import utilidades.Punto;

public abstract class NaveEnemiga extends Nave {

	public NaveEnemiga(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
	}

}
