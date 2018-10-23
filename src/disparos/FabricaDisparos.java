package disparos;

import juego.Agregable;
import juego.Mapa;

public abstract class FabricaDisparos {

	protected Agregable map;
	
	public FabricaDisparos(Agregable map) {
		this.map = map;
	}
	
	public abstract Disparo crearDisparo(int x, int y);
}
