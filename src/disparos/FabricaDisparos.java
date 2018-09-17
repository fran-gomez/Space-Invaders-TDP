package disparos;

import java.awt.Rectangle;

public abstract class FabricaDisparos {

	public FabricaDisparos() {
	}
	
	public abstract Disparo crearDisparo(int x, int y);
	

	public Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y);
	}
}
