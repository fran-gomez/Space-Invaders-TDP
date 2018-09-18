package disparos;

import juego.Mapa;
import utilidades.Constantes;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple(Mapa map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		Disparo disp = new DisparoSimple(x, y, 15, 100, Constantes.NAVE_ALIADA_DANIO);
		map.addToObjects(disp);
		return disp;
	}

}
