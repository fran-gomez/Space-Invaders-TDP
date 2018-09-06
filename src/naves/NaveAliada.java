package naves;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

import disparos.Disparo;
import juego.GameObject;
import juego.Nave;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class NaveAliada extends Nave {

	public NaveAliada(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad);

	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVE_ALIADA_WIDTH, Constantes.NAVE_ALIADA_HEIGHT);
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

	public void colisionar(Disparo d) {
		
	}
	
	public void colisionar(NaveEnemiga ne) {
		
	}
	
	public void mover(int d) {
		int nuevoX = (int) rec.getLocation().getX();
		switch (d) {
		case 1:
			if (rec.getLocation().getX() < Constantes.MAP_WIDTH - Constantes.NAVE_ALIADA_WIDTH)
				nuevoX += Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		case -1:
			if (rec.getLocation().getX() > 0)
				nuevoX -= Constantes.NAVE_ALIADA_VELOCIDAD;
			break;
		}
		rec.setLocation(nuevoX, (int) rec.getLocation().getY());
		this.setLocation((int)rec.getLocation().getX(), (int)rec.getLocation().getY());
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/naves/NaveAliada.jpg");
	}
}
