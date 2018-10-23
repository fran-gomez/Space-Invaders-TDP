package power_ups;

import Inteligencias.InteligenciaPowerUpDefecto;
import javax.swing.ImageIcon;

import juego.GameObject;
import juego.ObjectState;

public abstract class PowerUp extends GameObject {

	private InteligenciaPowerUpDefecto inteligencia;
	
	public PowerUp(int x, int y, int vida, int durabilidad) {
		super(x, y, vida, durabilidad);
		state = new ObjectState(vida, durabilidad);
		inteligencia = new InteligenciaPowerUpDefecto();
	}

	public void mover() {
		inteligencia.actualizarPosicion(this);
	}
	
	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}
	
	@Override
	public ImageIcon getGrafico() {
		// TODO Auto-generated method stub
		return new ImageIcon("src/resources/Crab.png");
	}
	
	public abstract void efecto();
}
