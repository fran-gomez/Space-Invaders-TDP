package disparos;

public abstract class FabricaDisparos {

	protected int x, y;
	
	public FabricaDisparos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract Disparo crearDisparo();
}
