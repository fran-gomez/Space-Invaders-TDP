package disparos;

public class FabricaTriple extends FabricaDisparos {

	public FabricaTriple() {
	}

	@Override
	public Disparo crearDisparo(int x, int y) {
		return new DisparoTriple(x, y, 0, 0, 3);
	}

}
