package disparos;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple() {
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		return new DisparoSimple(x, y, 15, 100, 3);
	}

}
