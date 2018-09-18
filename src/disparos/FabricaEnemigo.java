package disparos;

import juego.Mapa;
import utilidades.Constantes;

public class FabricaEnemigo extends FabricaDisparos {

	public FabricaEnemigo(Mapa map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoEnemigo(x, y, 15, 100, Constantes.NAVE_ALIADA_DANIO); //TODO change damage
		map.addToObjects(disp);
		return disp;
	}

}
