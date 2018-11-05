package disparos;

import juego.Agregable;

public abstract class DisparoAliado extends Disparo {

	public DisparoAliado(int x, int y, int vida, int dmg, Agregable mapa) {
		super(x, y, vida, dmg, mapa);
	}
}
