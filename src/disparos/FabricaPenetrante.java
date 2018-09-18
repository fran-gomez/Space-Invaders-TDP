package disparos;

import juego.Mapa;

public class FabricaPenetrante extends FabricaDisparos {

	public FabricaPenetrante(Mapa map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoPenetrante(x, y, 0, 0, 5);
		map.addToObjects(disp);
		return disp;
	}

}
