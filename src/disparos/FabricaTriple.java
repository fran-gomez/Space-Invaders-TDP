package disparos;

import juego.Agregable;

public class FabricaTriple extends FabricaSimple {

	private int contadorDisp;

	public FabricaTriple(Agregable map) {
		super(map);
		contadorDisp = 10;
	}

	@Override
	public void crearDisparo(int x, int y) {

		if (contadorDisp > 0) {
			super.crearDisparo(x - 15, y);
			super.crearDisparo(x, y - 5);
			super.crearDisparo(x + 15, y);
			contadorDisp--;
		}else {
			super.crearDisparo(x, y);
		}
	}

}
