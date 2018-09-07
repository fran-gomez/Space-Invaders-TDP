package power_ups;
import juego.GameObject;

public abstract class PowerUp extends GameObject {

	public PowerUp(int x, int y, int vida, int durabilidad) {
		super(x,y, vida, durabilidad);
		// TODO Auto-generated constructor stub
	}
	
	public void colision(GameObject obs) {
		obs.colision(this);
	}

}
