package disparos;

import juego.Agregable;
import juego.Mapa;
import utilidades.Constantes;

public class FabricaDisparoEnemigo extends FabricaDisparos {

	public FabricaDisparoEnemigo(Agregable map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoEnemigo(x, y, 15, 100, Constantes.NAVE_ALIADA_DANIO); //TODO change damage
		map.addToObjects(disp);
		return disp;
	}

}
