package disparos;

import juego.Agregable;
import utilidades.Constantes;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple(Agregable map) {
		super(map);
	}

	@Override
	public void crearDisparo(int x, int y) {
		Disparo disp = new DisparoSimple(x, y, 15, 100, Constantes.NAVE_ALIADA_DANIO, map);
		map.addToObjects(disp);
	}

}
