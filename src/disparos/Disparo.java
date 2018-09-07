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
	
	public void colision(GameObject obs) {
		obs.colision(this);
	}

}
