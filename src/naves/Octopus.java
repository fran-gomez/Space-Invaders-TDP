package naves;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Inteligencias.Inteligencia;
import disparos.Disparo;
import juego.GameObject;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class Octopus extends NaveEnemiga {

	public Octopus(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad, Inteligencia intel) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, intel);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.OCTOPUS_WIDTH, Constantes.OCTOPUS_HEIGHT);
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
	public ImageIcon getGrafico() {
		return new ImageIcon("src/naves/Octopus.jpg");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada naveEnemiga) {
	}

	@Override
	public void colision(Obstaculo naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Disparo disparo) {
	}



}
