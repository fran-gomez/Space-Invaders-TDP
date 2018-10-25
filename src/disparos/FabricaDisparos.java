package disparos;

import juego.Agregable;

public abstract class FabricaDisparos {

	protected Agregable map;
	
	public FabricaDisparos(Agregable map) {
		this.map = map;
	}
	
	public abstract void crearDisparo(int x, int y);
}
