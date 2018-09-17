package disparos;

public class FabricaPenetrante extends FabricaDisparos {

	public FabricaPenetrante(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Disparo crearDisparo() {
		return new DisparoPenetrante(x, y, 0, 0);
	}

}
