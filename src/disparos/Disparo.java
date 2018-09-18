package disparos;

import juego.GameObject;
import utilidades.Constantes;

public abstract class Disparo extends GameObject {

	protected int dmg;
	
	public Disparo(int x, int y, int vida, int durabilidad, int dmg) {
		super(x, y, vida, durabilidad);
		this.dmg = dmg;
		// TODO Auto-generated constructor stub
	}
	
	public void mover() {
		//Chequear que siga en el map
		if(rec.y < 0 || rec.y > Constantes.MAP_HEIGHT) {
			eliminar();
		}
	}
}
