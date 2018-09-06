package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class UFO extends NaveEnemiga {

	public UFO(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel) {
		super(x,y, vida, durabilidad, alcance, dmg, velocidad, intel);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x,y,Constantes.UFO_WIDTH, Constantes.UFO_HEIGHT);
	}

	@Override
	public void disparar() {
	
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
	
	}

	public String getName() {
		return "UFO";
	}

	@Override
	public void borrar() {
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/naves/UFO.jpg");
	}
}
