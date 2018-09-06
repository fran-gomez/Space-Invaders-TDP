package naves;
import juego.Nave;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;
	
	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia inteligencia) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad);
		this.inteligencia = inteligencia;
	}

}
