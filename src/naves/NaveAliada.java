package naves;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import juego.GameObject;
import juego.Nave;
import power_ups.PowerUp;
import utilidades.Constantes;
import utilidades.Recuadro;

public final class NaveAliada extends Nave {

	public NaveAliada(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad);

		visual = new ImageIcon("NaveAliada.jpg");
	}

	@Override
	protected Recuadro createRectangle(int x, int y) {
		return new Recuadro(x, y, Constantes.NAVE_ALIADA_WIDTH, Constantes.NAVE_ALIADA_HEIGHT);
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
		return "Aliado";
	}

	@Override
	public void colision(GameObject o1) {
	}

	public void mover(int d) {
		int nuevoX = rec.x();
		switch (d) {
		case 1:
			if (rec.x() < Constantes.MAP_WIDTH - Constantes.NAVE_ALIADA_WIDTH)
				nuevoX += Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		case -1:
			if (rec.x() > 0)
				nuevoX -= Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		}
		rec.setX(nuevoX);
		this.setLocation(rec.x(), rec.y());
	}

	@Override
	public void mover() {
	}
}
