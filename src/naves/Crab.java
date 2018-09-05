package naves;

import javax.swing.ImageIcon;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Recuadro;

public final class Crab extends NaveEnemiga {

	public Crab(Recuadro posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(posicion, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
		visual = new ImageIcon("Crab.jpg");
	}

	@Override
	public void disparar() {
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	@Override
	public void borrar() {
	}

	public String getName() {
		this.setIcon(visual);
		return "Crab";
	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}
}
