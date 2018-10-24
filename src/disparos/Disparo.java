package disparos;

import juego.Agregable;
import juego.GameObject;
import utilidades.Constantes;

public abstract class Disparo extends GameObject {

	protected int dmg;
	
	public Disparo(int x, int y, int vida, int durabilidad, int dmg, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
		this.dmg = dmg;
	}
	
	@Override
	public void mover() {
		//Chequear que siga en el map
		if(rec.y < 0 || rec.y > Constantes.MAP_HEIGHT) {
			eliminar();
		}
	}
	
	public int getDmg() {
		return dmg;
	}
}
