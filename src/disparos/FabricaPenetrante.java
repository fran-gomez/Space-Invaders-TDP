package disparos;

import juego.Agregable;
import juego.Mapa;

public class FabricaPenetrante extends FabricaDisparos {

	public FabricaPenetrante(Agregable map) {
		super(map);
	}

	@Override
	public void crearDisparo(int x, int y) {
		Disparo disp = new DisparoPenetrante(x, y, 0, 0, 5, map);
		map.addToObjects(disp);
	}

}
