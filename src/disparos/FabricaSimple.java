package disparos;

public class FabricaSimple extends FabricaDisparos {

	public FabricaSimple(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Disparo crearDisparo() {
		return new DisparoSimple(x, y, 0, 0);
	}

}
