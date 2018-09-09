package naves;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.Disparo;
import juego.GameObject;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Crab extends NaveEnemiga {

	public Crab(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.CRAB_WIDTH, Constantes.CRAB_HEIGHT);
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
		return "Crab";
	}



	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/Crab.jpg");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Disparo disparo) {
	}

}
