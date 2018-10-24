package disparos;

import juego.Agregable;
import juego.Mapa;
import utilidades.Constantes;

public class FabricaDisparoEnemigo extends FabricaDisparos {

	public FabricaDisparoEnemigo(Agregable map) {
		super(map);
	}

	@Override
	public void crearDisparo(int x, int y) {
		Disparo disp = new DisparoEnemigo(x, y, 15, 100, Constantes.NAVE_ALIADA_DANIO, map);
		map.addToObjects(disp);
	}

}
