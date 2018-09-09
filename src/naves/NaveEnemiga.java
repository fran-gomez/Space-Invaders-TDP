package naves;

import Inteligencias.Inteligencia;
import disparos.Disparo;
import juego.GameObject;
import juego.Nave;
import obstaculos.Obstaculo;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;

	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia inteligencia) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad);
		this.inteligencia = inteligencia;
	}

	@Override
	public void mover() {
		inteligencia.actualizarPosicion(this);
	}

	public void colision(GameObject obs) {
		obs.colision(this);
	}
	
	public void colision(NaveAliada na) {
		na.recibirDano(this.state.getDmg());
	}
	
	public void colision(Obstaculo o) {
		this.recibirDano(o.getDmg());
		System.out.println("Colision de nave enemiga con obstaculo.");
	}
}
