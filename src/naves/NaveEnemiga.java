package naves;

import Inteligencias.Inteligencia;
import juego.GameObject;
import juego.Mapa;
import juego.Nave;
import juego.NaveState;
import obstaculos.Obstaculo;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;

	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia inteligencia, Mapa m) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, m);
		this.inteligencia = inteligencia;
	}

	@Override
	public void mover() {
		inteligencia.actualizarPosicion(this);
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	@Override
	public void colision(NaveAliada na) {
		na.recibirDano(state.getDmg());
	}

	@Override
	public void colision(Obstaculo o) {
		//this.recibirDano(o.getDmg());
		//System.out.println("Colision de nave enemiga con obstaculo.");
	}
}
