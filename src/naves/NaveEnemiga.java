package naves;
import juego.Nave;
import utilidades.Recuadro;

public abstract class NaveEnemiga extends Nave {

	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad);
	}

}
