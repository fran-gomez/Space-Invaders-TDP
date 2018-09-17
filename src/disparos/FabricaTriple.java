package disparos;

public class FabricaTriple extends FabricaDisparos {

	public FabricaTriple(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Disparo crearDisparo() {
		return new DisparoTriple(x, y, 0, 0);
	}

}
