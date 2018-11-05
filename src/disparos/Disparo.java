package disparos;

import juego.Agregable;
import juego.GameObject;
import juego.Visitor;
import utilidades.Constantes;

public abstract class Disparo extends GameObject {

	protected int dmg;

	public Disparo(int x, int y, int vida, int dmg, Agregable mapa) {
		super(x, y, vida, mapa);
		this.dmg = dmg;
	}

	@Override
	public void mover() {
		// Chequear que siga en el map
		if (rec.y < 0 || rec.y > Constantes.MAP_HEIGHT) {
			eliminar();
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	public int getDmg() {
		return dmg;
	}
}
