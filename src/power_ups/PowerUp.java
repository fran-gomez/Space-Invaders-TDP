package power_ups;

import Inteligencias.InteligenciaPowerUpDefecto;
import javax.swing.ImageIcon;

import juego.Agregable;
import juego.GameObject;
import juego.ObjectState;
import naves.NaveAliada;

public abstract class PowerUp extends GameObject {

	private InteligenciaPowerUpDefecto inteligencia;
	
	public PowerUp(int x, int y, int vida, int durabilidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
		state = new ObjectState(vida, durabilidad);
		inteligencia = new InteligenciaPowerUpDefecto();
	}

	@Override
	public void mover() {
		inteligencia.actualizarPosicion(this);
	}
	
	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}
	
	@Override
	public void colision(NaveAliada naveAliada) {
		//naveAliada.aplicarPowerUp(this);
		eliminar();
	}
	
	@Override
	public ImageIcon getGrafico() {
		// TODO Auto-generated method stub
		return new ImageIcon("src/resources/Crab.png");
	}
	
	public abstract void efecto();
}
