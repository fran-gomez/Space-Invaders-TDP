package naves;

import javax.swing.ImageIcon;

import juego.GameObject;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class Octopus extends NaveEnemiga {

	public Octopus(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad);
		// TODO Auto-generated constructor stub
		visual = new ImageIcon("Octopus.jpg");
	}

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x, y, Constantes.OCTOPUS_WIDTH, Constantes.OCTOPUS_HEIGHT);
	}

	@Override
	public void disparar() {

	}

	@Override
	public void aplicarPowerUp(PowerUp p) {

	}

	public String getName() {
		return "Octopus";
	}

	@Override
	public void borrar() {

	}

	@Override
	public void colision(GameObject o1) {
	}

	@Override
	public void mover() {
	}

}
