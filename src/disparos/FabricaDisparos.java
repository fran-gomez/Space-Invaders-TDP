package disparos;

import juego.Mapa;

public abstract class FabricaDisparos {

	protected Mapa map;
	
	public FabricaDisparos(Mapa map) {
		this.map = map;
	}
	
	public abstract Disparo crearDisparo(int x, int y);
}
