package disparos;

import juego.Agregable;
import juego.Mapa;

public class FabricaTriple extends FabricaDisparos {

	public FabricaTriple(Agregable map) {
		super(map);
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		
		Disparo disp1 = new DisparoSimple(x - 15, y, 10, 0, 30);
		Disparo disp2 = new DisparoSimple(x, y - 5, 10, 0, 30);
		Disparo disp3 = new DisparoSimple(x + 15, y, 10, 0, 30);

		map.addToObjects(disp1);
		map.addToObjects(disp2);
		map.addToObjects(disp3);

		return disp2;
	}

}
