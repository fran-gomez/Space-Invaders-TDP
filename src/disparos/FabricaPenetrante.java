package disparos;

public class FabricaPenetrante extends FabricaDisparos {

	public FabricaPenetrante() {
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		return new DisparoPenetrante(x, y, 0, 0, 5);
	}

}
