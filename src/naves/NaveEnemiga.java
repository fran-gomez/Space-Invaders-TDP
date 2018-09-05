package naves;
import juego.Nave;
import utilidades.Recuadro;

public abstract class NaveEnemiga extends Nave {

	public NaveEnemiga(Recuadro posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
	}

}
