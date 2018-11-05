package power_ups;

import Inteligencias.InteligenciaPowerUpDefecto;
import javax.swing.ImageIcon;

import juego.Agregable;
import juego.GameObject;
import juego.Visitor;

public abstract class PowerUp extends GameObject {

	private InteligenciaPowerUpDefecto inteligencia;

	public PowerUp(int x, int y, int vida, int durabilidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
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
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public abstract ImageIcon getGrafico();
}
