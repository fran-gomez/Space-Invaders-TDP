package disparos;

import juego.Mapa;

public class FabricaTriple extends FabricaDisparos {

	public FabricaTriple(Mapa map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoTriple(x, y, 0, 0, 3);
		map.addToObjects(disp);
		return disp;
	}

}
