package disparos;

import juego.Agregable;

public class FabricaPenetrante extends FabricaSimple {

	private int contador;

	public FabricaPenetrante(Agregable map) {
		super(map);
		contador = 10;
	}

	@Override
	public void crearDisparo(int x, int y) {
		if (contador > 0) {
			Disparo disp = new DisparoPenetrante(x, y, 10, 10, 5, map);
			map.addToObjects(disp);
		} else {
			super.crearDisparo(x, y);
		}
	}

}
