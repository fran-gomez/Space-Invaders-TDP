package naves;

import java.awt.Rectangle;

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
	public String getName() {
		return "Aliado";
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
		this.setLocation((int) rec.getLocation().getX(), (int) rec.getLocation().getY());
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/NaveAliada.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		System.out.println("Colision de nave aliada con naveEnemiga");
		naveEnemiga.eliminar();
		naveEnemiga.setVida(0);
	}

	@Override
	public void colision(NaveAliada naveAliada) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Disparo disparo) {
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

}
