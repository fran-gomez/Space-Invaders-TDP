package disparos;

import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;

public abstract class Disparo extends GameObject {

	public Disparo(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		// TODO Auto-generated constructor stub
	}

	public void colisionar(NaveAliada na) {
		
	}
	
	public void colisionar(NaveEnemiga ne) {
		
	}
	
	public void colisionar(Obstaculo o) {
		
	}
}
