package naves;

import javax.swing.ImageIcon;

import power_ups.PowerUp;
import utilidades.Punto;

public final class Crab extends NaveEnemiga {

	public Crab(Punto posicion, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
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
	public void actualizarPosicion() {
	}

	@Override
	public void borrar() {
	}

	@Override
	public void colision() {
	}

	public String getName() {
		this.setIcon(visual);
		return "Crab";
	}
}
