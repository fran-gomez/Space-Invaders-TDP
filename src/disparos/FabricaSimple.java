package disparos;

import juego.Mapa;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple(Mapa map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoSimple(x, y, 15, 100, 3);
		map.addToObjects(disp);
		return disp;
	}

}
