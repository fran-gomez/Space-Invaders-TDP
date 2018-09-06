package naves;
import Inteligencias.Inteligencia;
import disparos.Disparo;
import juego.Nave;
import obstaculos.Obstaculo;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;
	
	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia inteligencia) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad);
		this.inteligencia = inteligencia;
	}

	public abstract void colisionar(NaveAliada na);
	public abstract void colisionar(Obstaculo o);
	public abstract void colisionar(Disparo d);
}
